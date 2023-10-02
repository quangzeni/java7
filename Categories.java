package BaitapB4;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int indexCatagories) {
        System.out.println("Nhập thông tin Danh mục:");
        if (arrCategories == null || indexCatagories == 0) {
            this.catalogId = 1;
        } else {
            this.catalogId = arrCategories[indexCatagories - 1].getCatalogId()+1;
        }
        System.out.println("Nhập tên Danh mục:");
        do {
            this.catalogName = scanner.nextLine();
            if (!this.catalogName.isEmpty() && this.catalogName.length() <= 50) {
                boolean check = true;
                for (int i = 0; i < indexCatagories; i++) {
                    if (arrCategories[i].getCatalogName().equals(this.catalogName)) {
                        check = false;
                        System.out.println("Tên trùng lăp, mời nhập lại");
                        break;
                    }
                }
                if (check) {
                    break;
                }
            } else {
                System.out.println("Tên danh mục không được trống và tối đa 50 ký tự.");
            }
        } while (true);
//        Mô tả
        System.out.println("Nhập mô tả danh mục:");
        this.descriptions = scanner.nextLine();
//        Trạng thái
        System.out.println("Nhập trạng thái hoạt động của danh mục:");
        while (true) {
            String temp = scanner.nextLine();
            if (temp.equalsIgnoreCase("true") || temp.equalsIgnoreCase("false")) {
                this.catalogStatus = Boolean.parseBoolean(temp);
                break;
            } else {
                System.out.println("Phải nhập là true hoặc false");
            }
        }

    }

    public void displayData() {
        System.out.printf("ID: %d- Name: %s - Mô tả: %s - Trạng thái: %s\n", this.catalogId, this.catalogName, this.descriptions, this.catalogStatus ? "Hoạt động" : "Không hoạt động");
//        if (this.catalogStatus){
//            System.out.println("Hoạt động");
//        }else {
//            System.out.println("Không hoạt động");
//        }
    }

}
