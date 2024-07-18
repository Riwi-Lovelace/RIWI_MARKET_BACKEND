package com.riwi.RiwiMarket.infrastructure.services;

import com.riwi.RiwiMarket.api.dtos.requests.ProductRequest;
import com.riwi.RiwiMarket.api.dtos.responses.ProductResponse;
import com.riwi.RiwiMarket.domain.entities.Brand;
import com.riwi.RiwiMarket.domain.entities.Category;
import com.riwi.RiwiMarket.domain.entities.Product;
import com.riwi.RiwiMarket.domain.entities.Subcategory;
import com.riwi.RiwiMarket.domain.repositories.BrandRepository;
import com.riwi.RiwiMarket.domain.repositories.CategoryRepository;
import com.riwi.RiwiMarket.domain.repositories.ProductRepository;
import com.riwi.RiwiMarket.domain.repositories.SubcategoryRepository;
import com.riwi.RiwiMarket.infrastructure.abstract_services.IProductService;
import com.riwi.RiwiMarket.infrastructure.helpers.SupportService;
import com.riwi.RiwiMarket.infrastructure.helpers.mappers.ProductMapper;
import com.riwi.RiwiMarket.util.exceptions.BadRequestException;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import java.io.*;
import java.util.*;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final ProductMapper productMapper;
    @Autowired
    private final SupportService<Product> SupportService;
    @Autowired
    private final BrandRepository brandRepository;
    @Autowired
    private final SupportService<Brand> supportBrand;
    @Autowired
    private final SubcategoryRepository subcategoryRepository;
    @Autowired
    private final SupportService<Subcategory> supportSubcategory;
    @Autowired
    private final SupportService<Category> supportCategory;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Override
    public ProductResponse create(ProductRequest request) {
        Product product= this.productMapper.toEntity(request);
        Subcategory subcategory= this.supportSubcategory.findById(this.subcategoryRepository ,request.getSubcategoryID(),"SubCategory");
        product.setPrice(new BigDecimal(0));
        product.setSubcategory(subcategory);
        product.setStatus(true);
        return this.productMapper.toResponse(this.productRepository.save(product));
    }

    @Override
    public ProductResponse read(Long id) {
        return this.productMapper.toResponse(this.find(id));
    }

    @Override
    public ProductResponse update(Long aLong, ProductRequest request) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public ProductResponse updateProductDescription(Long id, String description) {
      Product product =  SupportService.findById(productRepository, id, "product");
      product.setDescription(description);
      return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ICsvBeanWriter getCsv(HttpServletResponse response) throws IOException {
        List<Product> products = this.productRepository.findAll();
        ICsvBeanWriter writer = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] header={"Id","Name","Price","Iva","Description","Status","UrlImg","Subcategory","Brand"};
        String[] properties = {"id","name","price","iva","description","status","urlImg","subcategoryName","IdBrand"};
        writer.writeHeader(header);
        for (Product product: products) {
                product.setSubcategoryName(product.getSubcategory().getName());
                if (product.getBrand() !=null){
                    product.setIdBrand(product.getBrand().getId());
                }else {
                    product.setIdBrand(0L);
                }
                if (product.getDescription() == null){
                    product.setDescription("N/A");
                }


            writer.write(product,properties);
        }
        return writer;
    }


    @Override
    public List<ProductResponse> setCsv(MultipartFile file){
        List<Product> listProducts =new ArrayList<>();


        List<Subcategory> subcategoryList = this.subcategoryRepository.findAll();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line=br.readLine() )!=null){
                Product product = new Product();
                String[] info = line.split(",");
                product.setName(info[1]);
                if (!info[2].equals("Price")){
                    product.setPrice(new BigDecimal(info[2]));
                }
                if (!info[3].equals("Iva")){
                    product.setIva(new BigDecimal(info[3]));
                }
                product.setDescription(info[4]);
                product.setStatus(Boolean.parseBoolean(info[5]));
                product.setUrlImg(info[6]);
                subcategoryList.forEach(subcategory -> {
                    if (subcategory.getName().equals(info[7])){
                        product.setSubcategory(subcategory);
                    }
                });
                if (!info[8].equals("Brand")) {
                    if (!info[8].equals("0")) {
                        product.setBrand(supportBrand.findById(this.brandRepository, Long.getLong(info[8]), "Brand"));
                    }
                }
                listProducts.add(product);
                System.out.println(line);
                System.out.println("-------------------");
                System.out.println(listProducts);
            }
        }catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
        listProducts.remove(0);
        return listProducts.stream().map(this::convert).collect(Collectors.toList());
    }

    public ProductResponse convert(Product product){
       Product newProduct = this.productRepository.save(product);

        return this.productMapper.toResponse(newProduct);
    }

    @Override
    public ByteArrayInputStream getXls() throws IOException {{
        List<Product> products = this.productRepository.findAll();
        try(Workbook workbook = new XSSFWorkbook();) {
            Sheet sheet= workbook.createSheet("Product");
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Price");
            header.createCell(3).setCellValue("Iva");
            header.createCell(4).setCellValue("Description");
            header.createCell(5).setCellValue("Status");
            header.createCell(6).setCellValue("UrlImg");
            header.createCell(7).setCellValue("Subcategory");
            header.createCell(8).setCellValue("Brand");

            int rowIdx = 1;
            for (Product product : products){
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(product.getId());
                row.createCell(1).setCellValue(product.getName());
                row.createCell(2).setCellValue(product.getPrice().toString());
                row.createCell(3).setCellValue(product.getIva().toString());
                row.createCell(4).setCellValue(product.getDescription());
                row.createCell(5).setCellValue(product.getStatus());
                row.createCell(6).setCellValue(product.getUrlImg());
                row.createCell(7).setCellValue(product.getSubcategory().getName());

                if (product.getBrand() != null) {
                    row.createCell(8).setCellValue(product.getBrand().getId());

                }else {
                    row.createCell(8).setCellValue("0");
                }

            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
    }

    @Override
    public List<ProductResponse> setXlsx(MultipartFile archive) throws IOException{
        List<Product> listProduct = new ArrayList<>();
        List<Subcategory> subcategoryList = this.subcategoryRepository.findAll();
       try (Workbook workbook = new XSSFWorkbook(archive.getInputStream())){
           Sheet sheet= workbook.getSheetAt(0);
           Iterator<Row> rowIterator = sheet.iterator();
           int conta=0;
           while (rowIterator.hasNext()){
               Row row = rowIterator.next();
               Cell[] info = new Cell[9];
               Product product = new Product();
               if (conta!=0) {
               for (int ite =0;ite <9;ite++ ){
                   info[ite]=row.getCell(ite);
               }
                    product.setName(info[1].getStringCellValue());

                    product.setPrice(new BigDecimal(info[2].getStringCellValue()));

                    product.setIva(new BigDecimal(info[3].getStringCellValue()));
                    if (info[4] != null) {
                        product.setDescription(info[4].getStringCellValue());
                    }
                     product.setStatus(info[5].getBooleanCellValue());
                    product.setUrlImg(info[6].getStringCellValue());
                    subcategoryList.forEach(subcategory -> {
                        if (subcategory.getName().equals(info[7].getStringCellValue())) {
                            product.setSubcategory(subcategory);
                        }
                    });
                    listProduct.add(product);
                }
                conta++;
           }
       }
        return listProduct.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public ProductResponse addProductPrice(Long id, BigDecimal price) {
        Product product =  SupportService.findById(productRepository, id, "price");
        if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            return null;
        }
        product.setPrice(price);
        return productMapper.toResponse(productRepository.save(product));
      }

    @Override
    public List<ProductResponse> findBySubcategory(Long id) {
        return this.productMapper.toListResponse(this.productRepository.findBySubcategory_Id(id));
    }

    @Override
    public List<ProductResponse> findByCategory(Long id) {
        Category category = this.supportCategory.findById(categoryRepository,id,"Category");
        List<Product> productList = this.productRepository.findAll();
        List<Product> products = new ArrayList<>();
        productList.forEach(product -> {
            if (category.getId()==product.getSubcategory().getCategory().getId()){
                products.add(product);
            }
        });
        return this.productMapper.toListResponse(products);
    }

    @Override
    public List<ProductResponse> findByBrand(Long id) {
        return this.productMapper.toListResponse(this.productRepository.findByBrand_id(id));
    }

    @Override
    public List<ProductResponse> findByName(String name) {
        return this.productRepository.findByName(name)
        .stream()
        .map(this.productMapper::toResponse)
        .collect(Collectors.toList());
    }
    /*/
    @Override
    public List<ProductResponse> findBySubcategoryId(Long id) {
        return this.productRepository.findBySubcategoryId(id)
        .stream()
        .map(this.productMapper::toResponse)
        .collect(Collectors.toList());
    }*/

    @Override
    public Page<ProductResponse> getAll(int page, int size) {
        if(page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return this.productRepository.findAll(pagination)
            .map(this.productMapper::toResponse);
    }

    private Product find(Long id){
        return this.productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("There is not prodcut with the provided id"));
    }
}
