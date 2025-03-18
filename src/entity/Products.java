package entity;

import java.util.Scanner;

public class Products implements IApp{
    private String id_product;
    private String name_product;
    private float import_price;
    private float export_price;
    private String title;
    private String description;
    private int quantity;
    private int id_category;
    private int status;

    public Products(){

    }

    public Products(String id_product,
                    String name_product,
                    float import_price,
                    float export_price,
                    String title,
                    String description,
                    int quantity,
                    int id_category,
                    int status) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.import_price = import_price;
        this.export_price = export_price;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.id_category = id_category;
        this.status = status;
    }

    public String getId_product() {
        return id_product;
    }
    public void setId_product(String id_product) {
        this.id_product = id_product;
    }
    public String getName_product() {
        return name_product;
    }
    public void setName_product(String name_product) {
        this.name_product = name_product;
    }
    public float getImport_price() {
        return import_price;
    }
    public void setImport_price(float import_price) {
        this.import_price = import_price;
    }
    public float getExport_price() {
        return export_price;
    }
    public void setExport_price(float export_price) {
        this.export_price = export_price;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getId_category() {
        return id_category;
    }
    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, boolean isUpdate) {
        boolean result = false;

        if (!isUpdate) {
            while (!result) {
                System.out.print("Nhập mã sản phẩm (5 ký tự bắt đầu bằng C, E, hoặc T): ");
                String id = scanner.nextLine().trim();
                if (id.length() == 5 && (id.startsWith("C") || id.startsWith("E") || id.startsWith("T"))) {
                    this.id_product = id;
                    result = true;
                } else {
                    System.out.println("Mã sản phẩm phải có 5 ký tự và bắt đầu bằng C, E, hoặc T!");
                }
            }
        }

        System.out.print("Nhập tên sản phẩm (10-100 ký tự): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty() && name.length() >= 10 && name.length() <= 100) {
            this.name_product = name;
        }

        System.out.print("Nhập giá nhập (lớn hơn 0): ");
        String importPriceStr = scanner.nextLine().trim();
        if (!importPriceStr.isEmpty()) {
            float price = Float.parseFloat(importPriceStr);
            if (price > 0) {
                this.import_price = price;
            }
        }

        System.out.print("Nhập giá xuất (lớn hơn giá nhập * " + INTEREST + "): ");
        String exportPriceStr = scanner.nextLine().trim();
        if (!exportPriceStr.isEmpty()) {
            float price = Float.parseFloat(exportPriceStr);
            if (price > this.import_price * INTEREST) {
                this.export_price = price;
            }
        }

        System.out.print("Nhập tiêu đề sản phẩm: ");
        String input_title = scanner.nextLine().trim();
        if (!input_title.isEmpty()) {
            this.title = input_title.length() > 200 ? input_title.substring(0, 200) : input_title;
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine().trim();
        if (!description.isEmpty()) {
            this.description = description;
        }

        System.out.print("Nhập số lượng sản phẩm: ");
        String quantityStr = scanner.nextLine().trim();
        if (!quantityStr.isEmpty()) {
            this.quantity = Integer.parseInt(quantityStr);
        }

        System.out.print("Nhập mã danh mục: ");
        String categoryIdStr = scanner.nextLine().trim();
        if (!categoryIdStr.isEmpty()) {
            this.id_category = Integer.parseInt(categoryIdStr);
        }

        result = false;
        while (!result) {
            System.out.print("Nhập trạng thái sản phẩm (0,1,2): ");
            String statusStr = scanner.nextLine().trim();
            if (!statusStr.isEmpty()) {
                int status_input = Integer.parseInt(statusStr);
                if (status_input >= 0 && status_input <= 2) {
                    this.status = status_input;
                    result = true;
                } else {
                    System.out.println("Trạng thái phải là 0, 1 hoặc 2!");
                }
            } else {
                result = true;
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã sản phẩm: " + id_product);
        System.out.println("Tên sản phẩm: " + name_product);
//        System.out.println("Giá nhập: " + import_price);
        System.out.println("Giá xuất: " + export_price);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + id_category);

        String status_text;
        switch (status) {
            case 0:
                status_text = "Đang hoạt động";
                break;
            case 1:
                status_text = "Hết hàng";
                break;
            case 2:
                status_text = "Không hoạt động";
                break;
            default:
                status_text = "Không xác định";
        }
        System.out.println("Trạng thái: " + status_text);
    }
}
