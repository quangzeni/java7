package BaitapB4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private Date created;
    private Categories categories;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, Categories categories, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.categories = categories;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatagories) {
        System.out.println("Nhập thông tin sản phẩm");
        do {
            System.out.println("Nhập productId:");
            this.productId = scanner.nextLine();
            if (this.productId.length() == 4) {
                boolean check = true;
                if (this.productId.startsWith("C") || this.productId.startsWith("S") || this.productId.startsWith("A")) {
                    for (int i = 0; i < indexProduct; i++) {
                        if (this.productId.equals(arrProduct[i].getProductId())) {
                            check = false;
                            System.out.println("Tên trùng lăp, mời nhập lại");
                            break;
                        }
                    }
                }
                if (check) {
                    break;
                }
            } else {
                System.out.println("Nhập lại, mã sản phẩm gồm 4 ký tự");
            }
        } while (true);
        System.out.println("Nhập tên sản phẩm:");
        do {
            this.productName = scanner.nextLine();
            if (this.productName.isEmpty() || this.productName.length() <= 50) {
                boolean check = true;
                for (int i = 0; i < indexProduct; i++) {
                    if (this.productName.equals(arrProduct[i].getProductName())) {
                        break;
                    } else {
                        check = false;
                    }
                }
                if (check) {
                    break;
                } else {
                    System.out.println("Tên sản phẩm trùng lặp, nhập lại");
                }
            } else {
                System.out.println("Tên sản phẩm phải nhỏ hơn 50 ký tự và không để trống");
            }

        } while (true);
        System.out.println("Nhập giá sản phẩm");
        do {
            this.price = Float.parseFloat(scanner.nextLine());
            if (this.price >= 0) {
                break;
            } else {
                System.out.println("Giá sản phẩm phải lớn hơn không.");
            }
        } while (true);
        System.out.println("Nhập mô tả sản phẩm");
        this.description = scanner.nextLine();
//        Nhập ngày nhập sản phẩm.
        System.out.println("Nhập ngày nhập sản phẩm");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date created = sdf.parse(scanner.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Danh mục sản phẩm đang có");
        for (int i = 0; i < indexCatagories; i++) {
            System.out.printf("%d - %s", i + 1, arrCategories[i].getCatalogName());
        }
        System.out.println("Nhâp mã danh mục sản phẩm muốn chọn:");
        int danhmuc = Integer.parseInt(scanner.nextLine());
        this.categories = arrCategories[danhmuc - 1];
        System.out.println("Nhập trạng thái sản phẩm:");
        do{
            int productStatusCheck = Integer.parseInt(scanner.nextLine());
            if (productStatusCheck == 0||productStatusCheck ==1 || productStatusCheck ==2){
                this.productStatus = productStatusCheck;
                break;
            }else {
                System.out.println("Mã trạng thái chỉ là 0: Đang bán, 1: hết hàng hoặc 2: Không bán");
            }
        }while (true);
    }

    public void displayData(){
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá: %f - Mô tả: %s\n"
                ,this.productId, this.productName, this.price, this.description);
        System.out.printf("Ngày nhập: %sdf - Mã danh mục: %d - Trạng thái: %s\n",this.created, this.categories.getCatalogId(),
                (this.productStatus ==0)?"Đang bán":(this.productStatus ==1)?"Hết hàng":(this.productStatus == 2)?"Không bán":"Không hợp lệ");

    }

}

