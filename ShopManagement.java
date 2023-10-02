package BaitapB4;

import java.util.Scanner;

public class ShopManagement {
    static Categories[] arrCategories = new Categories[100];
    static Product[] arrProduct = new Product[100];
    static int indexCatagories = 0;
    static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*****Shop Menu******");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Kết thúc");
            System.out.println("Lựa chọn của bạn:");
            int selectShop = Integer.parseInt(scanner.nextLine());
            switch (selectShop) {
                case 1:
                    ShopManagement.displayMenuCatalog(scanner);
                    break;
                case 2:
                    ShopManagement.displayProductMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 3");
            }
        } while (true);
    }

    public static void displayMenuCatalog(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("*****Categories Meny*****");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            int selectCategories = Integer.parseInt(scanner.nextLine());
            switch (selectCategories) {
                case 1:
                    System.out.println("Số danh mục cần nhập:");
                    int catagoriesQuantity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < catagoriesQuantity; i++) {
                        Categories newCatagories = new Categories();
                        newCatagories.inputData(scanner, arrCategories, indexCatagories);
                        arrCategories[indexCatagories] = newCatagories;
                        indexCatagories++;
                    }
                    break;
                case 2:
                    System.out.println("Danh mục:");
                    for (int i = 0; i < indexCatagories; i++) {
                        arrCategories[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("Chọn mã danh mục cần cập nhật:");
                    int edit = Integer.parseInt(scanner.nextLine());
                    if (edit <= indexCatagories && edit > 0) {
                        System.out.println("Nhập lại thông tin danh mục có mã " + edit);
                        Categories editCatagories = new Categories();
                        editCatagories.inputData(scanner, arrCategories, indexCatagories);
                        editCatagories.setCatalogId(arrCategories[edit - 1].getCatalogId());
                        arrCategories[edit - 1] = editCatagories;
                    } else {
                        System.out.println("Mã danh mục không tồn tại");
                    }
                    break;
                case 4:
                    System.out.println("Chọn mã danh mục cần xóa");
                    int indexDelete = Integer.parseInt(scanner.nextLine()) - 1;
                    if (indexDelete >= 0 && indexDelete < indexCatagories) {
                        int deleteCategoriesId = arrCategories[indexDelete].getCatalogId();
                        boolean check = true;
                        for (int i = 0; i < index; i++) {
                            if (arrProduct[i].getCategories().getCatalogId() == deleteCategoriesId) {
                                System.out.println("Danh mục có chứa sản phẩm, không được xóa");
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            for (int j = indexDelete; j < indexCatagories; j++) {
                                arrCategories[j] = arrCategories[j + 1];
                            }
                            arrCategories[indexCatagories] = null;
                            indexCatagories--;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Chọn mã danh mục cần cập nhật:");
                    int editStatusId = Integer.parseInt(scanner.nextLine());
                    boolean ischeck = arrCategories[editStatusId - 1].isCatalogStatus();
                    if (editStatusId <= indexCatagories && editStatusId > 0) {
                        arrCategories[editStatusId - 1].setCatalogStatus(!ischeck);
                    } else {
                        System.out.println("Mã danh mục không tồn tại");
                    }
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 6");
            }
        } while (isExit);
    }

    public static void displayProductMenu(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("*****Product Management*****");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");
            int selectProduct = Integer.parseInt(scanner.nextLine());
            switch (selectProduct) {
                case 1:
                    System.out.println("Số lượng sản phẩm muốn nhập:");
                    int productQuatity = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < productQuatity; i++) {
                        Product newProduct = new Product();
                        newProduct.inputData(scanner, arrProduct, index, arrCategories, indexCatagories);
                        arrProduct[index] = newProduct;
                        index++;
                    }
                    break;
                case 2:
                    System.out.println("Sản phẩm:");
                    for (int i = 0; i < index; i++) {
                        arrProduct[i].displayData();
                    }
                    break;
                case 3:
                    float[] priceList = new float[100];
                    for (int i = 0; i < index; i++) {
                        float getPrice = arrProduct[i].getPrice();
                        priceList[i] = getPrice;
                    }
                    Product temp = null;
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (priceList[i] < priceList[j]) {
                                temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào mã sản phẩm cần cập nhật");
                    String productEditId = scanner.nextLine();
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductId().equals(productEditId)) {
                            Product editProduct = new Product();
//                            boolean isExitCheck = true;
//                            do {
//                                System.out.println("Nhập thông tin cập nhật cho sản phẩm có ID: "+productEditId);
//                                editProduct.inputData(scanner,arrProduct,index,arrCategories,indexCatagories);
//                                if (!editProduct.getProductId().equals(productEditId)){
//                                    System.out.println("Bạn nhập sai mã Id, nhập lại.");
//                                }else {
//                                    isExitCheck = false;
//                                }
//                            }while (isExitCheck);
                            System.out.println("Nhập thông tin cập nhật với ID tạm thời là S999");
                            editProduct.inputData(scanner, arrProduct, index, arrCategories, indexCatagories);
                            editProduct.setProductId(arrProduct[i].getProductId());
                            arrProduct[i] =  editProduct;
                        } else {
                            System.out.println("Không có sản phẩm bạn vừa nhập");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhập vào mã sản phẩm cần xóa:");
                    String producDeleteId = scanner.nextLine();
                    int productDeleteIdIndex = 0;
                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductId().equals(producDeleteId)){
                            productDeleteIdIndex = i;
                        }else {
                            System.out.println("Không tìm thấy sản phẩm cần xóa");
                        }
                    }
                    for (int i = productDeleteIdIndex; i < index; i++) {
                        arrProduct[productDeleteIdIndex] = arrProduct[productDeleteIdIndex+1];

                    }
                    index--;
                    break;
                case 6:

                    break;
                case 7:
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui lòng lựa choọn từ 1 đến 8");
            }
        } while (isExit);
    }
}
