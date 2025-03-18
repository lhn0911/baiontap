package presentation;

import entity.Categories;
import entity.Products;

import java.util.Scanner;

public class main {
    private static Categories[] categories = new Categories[100];
    private static Products[] products = new Products[100];
    private static int categoryCount = 0;
    private static int productCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("********************CATEGORIE MANAGEMENT*********************");
                        System.out.println("1. Danh sách danh mục");
                        System.out.println("2. Thêm mới danh mục");
                        System.out.println("3. Cập nhật danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Tìm kiếm danh mục theo tên");
                        System.out.println("6. Thoát");
                        System.out.print("Chọn chức năng: ");
                        int categoryChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (categoryChoice) {
                            case 1:
                                for (int i = 0; i < categoryCount; i++) {
                                    categories[i].displayData();
                                }
                                break;
                            case 2:
                                if (categoryCount < categories.length) {
                                    Categories category = new Categories();
                                    category.inputData(scanner, false);
                                    categories[categoryCount++] = category;
                                } else {
                                    System.out.println("Không thể thêm danh mục mới!");
                                }
                                break;
                            case 3:
                                System.out.print("Nhập mã danh mục cần cập nhật: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                boolean found = false;
                                for (int i = 0; i < categoryCount; i++) {
                                    if (categories[i].getId_category() == id) {
                                        System.out.println("Nhập thông tin mới cho danh mục: ");
                                        categories[i].inputData(scanner, true);
                                        System.out.println("Cập nhật danh mục thành công!");
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Không tìm thấy danh mục!");
                                }
                                break;
                            case 4:
                                System.out.print("Nhập mã danh mục cần xóa: ");
                                int deleteId = scanner.nextInt();
                                scanner.nextLine();

                                boolean deleted = false;
                                for (int i = 0; i < categoryCount; i++) {
                                    if (categories[i].getId_category() == deleteId) {
                                        categories[i] = categories[--categoryCount];
                                        System.out.println("Xóa danh mục thành công!");
                                        deleted = true;
                                        break;
                                    }
                                }
                                if (!deleted) {
                                    System.out.println("Không tìm thấy danh mục!");
                                }
                                break;
                            case 5:
                                System.out.print("Nhập tên danh mục cần tìm: ");
                                String name = scanner.nextLine();
                                for (int i = 0; i < categoryCount; i++) {
                                    if (categories[i] != null && categories[i].getName_category().contains(name)) {
                                        categories[i].displayData();
                                    }
                                }
                                break;
                            case 6:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                        if (categoryChoice == 6) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("************************PRODUCT MANAGEMENT*******************");
                        System.out.println("1. Danh sách sản phẩm");
                        System.out.println("2. Thêm mới sản phẩm");
                        System.out.println("3. Cập nhật sản phẩm");
                        System.out.println("4. Xóa sản phẩm");
                        System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
                        System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
                        System.out.println("7. Sắp xếp sản phẩm theo giá bán tăng dần");
                        System.out.println("8. Bán sản phẩm");
                        System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
                        System.out.println("10. Thoát");
                        System.out.print("Chọn chức năng: ");
                        int productChoice = scanner.nextInt();
                        scanner.nextLine();
                        switch (productChoice) {
                            case 1:
                                for (int i = 0; i < productCount; i++) {
                                    products[i].displayData();
                                }
                                break;
                            case 2:
                                if (productCount < products.length) {
                                    Products product = new Products();
                                    product.inputData(scanner, false);
                                    products[productCount++] = product;
                                } else {
                                    System.out.println("Không thể thêm sản phẩm mới!");
                                }
                                break;
                            case 3:
                                System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                                String updateId = scanner.nextLine().trim();

                                boolean updated = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getId_product().equals(updateId)) {
                                        System.out.println("Nhập thông tin mới cho sản phẩm: ");
                                        products[i].inputData(scanner, true);
                                        System.out.println("Cập nhật sản phẩm thành công!");
                                        updated = true;
                                        break;
                                    }
                                }
                                if (!updated) {
                                    System.out.println("Không tìm thấy sản phẩm!");
                                }
                                break;
                            case 4:
                                System.out.print("Nhập mã sản phẩm cần xóa: ");
                                String deleteId = scanner.nextLine();

                                boolean deleted = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getId_product().equals(deleteId)) {
                                        products[i] = products[--productCount];
                                        System.out.println("Xóa sản phẩm thành công!");
                                        deleted = true;
                                        break;
                                    }
                                }
                                if (!deleted) {
                                    System.out.println("Không tìm thấy sản phẩm!");
                                }
                                break;
                            case 5:
                                System.out.print("Nhập tên hoặc tiêu đề sản phẩm: ");
                                String searchName = scanner.nextLine();

                                boolean found = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getName_product().contains(searchName)) {
                                        products[i].displayData();
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Không tìm thấy sản phẩm!");
                                }
                                break;
                            case 6:
                                System.out.print("Nhập khoảng giá tối thiểu: ");
                                float minPrice = scanner.nextFloat();
                                System.out.print("Nhập khoảng giá tối đa: ");
                                float maxPrice = scanner.nextFloat();
                                scanner.nextLine();

                                boolean priceFound = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getImport_price() >= minPrice && products[i].getExport_price() <= maxPrice) {
                                        products[i].displayData();
                                        priceFound = true;
                                    }
                                }
                                if (!priceFound) {
                                    System.out.println("Không tìm thấy sản phẩm trong khoảng giá này!");
                                }
                                break;
                            case 7:
                                for (int i = 0; i < productCount - 1; i++) {
                                    for (int j = i + 1; j < productCount; j++) {
                                        if (products[i].getExport_price() > products[j].getExport_price()) {
                                            Products temp = products[i];
                                            products[i] = products[j];
                                            products[j] = temp;
                                        }
                                    }
                                }
                                System.out.println("Sản phẩm đã được sắp xếp theo giá bán tăng dần.");
                                for (int i = 0; i < productCount; i++) {
                                    products[i].displayData();
                                }
                                break;
                            case 8:
                                System.out.print("Nhập mã sản phẩm cần bán: ");
                                String sellId = scanner.nextLine();

                                boolean soldProduct = false;
                                for (int i = 0; i < productCount; i++) {
                                    if (products[i].getId_product().equals(sellId)) {
                                        System.out.print("Nhập số lượng cần bán: ");
                                        int quantity = scanner.nextInt();
                                        scanner.nextLine();

                                        if (quantity <= 0) {
                                            System.out.println("Số lượng không hợp lệ!");
                                            break;
                                        }

                                        if (products[i].getQuantity() >= quantity) {
                                            products[i].setQuantity(products[i].getQuantity() - quantity);
                                            System.out.println("Bán sản phẩm thành công!");
                                        } else {
                                            System.out.println("Số lượng sản phẩm không đủ!");
                                        }
                                        soldProduct = true;
                                        break;
                                    }
                                }
                                if (!soldProduct) {
                                    System.out.println("Không tìm thấy sản phẩm!");
                                }
                                break;
                            case 9:
                                if (categoryCount == 0) {
                                    System.out.println("Chưa có danh mục nào!");
                                    break;
                                }

                                for (int i = 0; i < categoryCount; i++) {
                                    int count = 0;
                                    for (int j = 0; j < productCount; j++) {
                                        if (products[j].getId_category() == categories[i].getId_category()) {
                                            count++;
                                        }
                                    }
                                    System.out.println("Danh mục: " + categories[i].getName_category() + " - Số lượng sản phẩm: " + count);
                                }
                                break;
                            case 10:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                        if (productChoice == 10) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}