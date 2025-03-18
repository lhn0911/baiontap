package entity;

import java.util.Scanner;

public class Categories implements IApp {
    private int id_category;
    private String name_category;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {

    }

    public Categories(int id_category,
                      String name_category,
                      int priority,
                      String description,
                      boolean status) {
        this.id_category = id_category;
        this.name_category = name_category;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        if (name_category.length() >= 6 && name_category.length() <= 50) {
            this.name_category = name_category;
        } else {
            System.out.println("Tên danh mục phải từ 6 đến 50 ký tự!");
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority >= 0) {
            this.priority = priority;
        } else {
            System.out.println("Độ ưu tiên phải lớn hơn hoặc bằng 0!");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.length() > 255 ? description.substring(0, 255) : description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, boolean isUpdate) {
        if (!isUpdate) {
            System.out.print("Nhập mã danh mục: ");
            setId_category(Integer.parseInt(scanner.nextLine()));
        }

        System.out.print("Nhập tên danh mục: ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) {
            setName_category(name);
        }

        System.out.print("Nhập độ ưu tiên: ");
        String priority = scanner.nextLine();
        if (!priority.trim().isEmpty()) {
            setPriority(Integer.parseInt(priority));
        }

        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        if (!description.trim().isEmpty()) {
            setDescription(description);
        }

        System.out.print("Nhập trạng thái (true/false): ");
        String status = scanner.nextLine();
        if (!status.trim().isEmpty()) {
            setStatus(Boolean.parseBoolean(status));
        }
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: " + id_category);
        System.out.println("Tên danh mục: " + name_category);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
    }
}
