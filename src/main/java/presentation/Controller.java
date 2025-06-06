package presentation;

import businessLogic.*;
import enums.Role;
import model.Administrator;
import model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Controller {
    private LoginGUI login;
    private DeliveryService delivery;
    private Administrator admin;

    public Controller(LoginGUI login){
        this.delivery = new DeliveryService();
        this.login = login;
        this.admin = new Administrator("Admin10", "aaa");

        login.loginBtnAL(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getUsernameTextF();
                String password = String.valueOf(login.getPasswordTextF());
                Role role = login.getRoleComboBox();

                if(role.equals(Role.CLIENT) && delivery.validateClient(username, password)){
                    ClientGUI clientGUI = new ClientGUI(admin);
                    clientGUI.setVisible(true);
                    login.setVisible(false);

                    clientGUI.menuBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MenuBaseProductsGUI menu = new MenuBaseProductsGUI(admin);
                        }
                    });

                    clientGUI.compositeProductsBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MenuCompositeProductsGUI menu = new MenuCompositeProductsGUI(admin);
                        }
                    });

                    clientGUI.searchBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SearchByCriteriaTable search = new SearchByCriteriaTable(admin, clientGUI.getTitleTextF(), clientGUI.getRatingTextF(), clientGUI.getCaloriesTextF(), clientGUI.getProteinTextF(), clientGUI.getFatTextF(), clientGUI.getSodiumTextF(), clientGUI.getPriceTextF());
                        }
                    });

                    clientGUI.backBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            clientGUI.setVisible(false);
                            login.setVisible(true);
                        }
                    });

                    clientGUI.createOrderAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            CreateOrderGUI orderGUI = new CreateOrderGUI(admin);
                            orderGUI.setVisible(true);
                            //clientGUI.setVisible(false);
                            String orderDate = clientGUI.orderDateTextF();
                            String orderTime = clientGUI.orderTimeTextF();
                            Order order = new Order(orderDate, orderTime);
                            List<MenuItem> products = new ArrayList<>();

                            orderGUI.addItemAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String item = orderGUI.getComboBoxText();
                            Set<BaseProduct> baseProducts = admin.getListProducts();
                            List<CompositeProduct> compositeProducts = admin.getListCompositeProducts();
                            for(BaseProduct b : baseProducts){
                                if(b.getTitle().compareTo(item) == 0){
                                    b.setQuantity(b.getQuantity() + 1);
                                    products.add(b);
                                }
                            }
                            for(CompositeProduct cp : compositeProducts){
                                if(cp.getTitle().compareTo(item) == 0){
                                    cp.setQuantity(cp.getQuantity() + 1);
                                    products.add(cp);
                                }
                            }
                        }
                    });
                            orderGUI.createOrderAL(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    List<Client> list = delivery.getClients();
                                    String username = login.getUsernameTextF();
                                    String password = String.valueOf(login.getPasswordTextF());

                                    for(Client c : list){
                                        if(c.getUsername().equals(username) && c.getPassword().equals(password)){
                                            c.setNumberOrders(c.getNumberOrders() + 1);
                                            order.setIdClient(c.getIdClient());
                                        }
                                    }
                                    delivery.addNewOrder(order, products);

                                }
                            });

                            orderGUI.backBtnAL(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    orderGUI.setVisible(false);
                                    clientGUI.setVisible(true);
                                }
                            });
                        }
                    });
                }else if(delivery.validateAdmin(username, password) && role.equals(Role.ADMINISTRATOR)){
                    AdministratorGUI adminGUI = new AdministratorGUI(admin);
                    adminGUI.setVisible(true);
                    login.setVisible(false);

                    adminGUI.menuBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MenuBaseProductsGUI menu = new MenuBaseProductsGUI(admin);
                        }
                    });

                    adminGUI.menuCompositeProductsBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MenuCompositeProductsGUI menu = new MenuCompositeProductsGUI(admin);
                        }
                    });

                    adminGUI.addProductBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BaseProduct newProduct = new BaseProduct(adminGUI.getTitleTextF(), adminGUI.getRatingTextF(), adminGUI.getCaloriesTextF(), adminGUI.getProteinTextF(), adminGUI.getFatTextF(), adminGUI.getSodiumTextF(), adminGUI.getPriceTextF());
                            admin.addNewBaseProduct(newProduct);
                        }
                    });

                    adminGUI.deleteProductBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BaseProduct b = new BaseProduct(adminGUI.getTitleTextF(), adminGUI.getRatingTextF(), adminGUI.getCaloriesTextF(), adminGUI.getProteinTextF(), adminGUI.getFatTextF(), adminGUI.getSodiumTextF(), adminGUI.getPriceTextF());
                            admin.deleteProduct(b);
                        }
                    });

                    adminGUI.createOrModifyProductAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            ModifyAndCreateCompositeProductGUI cp = new ModifyAndCreateCompositeProductGUI(admin);
                            cp.setVisible(true);
                            cp.modifyProductAL(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String selectedProduct = cp.getComboBoxText();
                                    String title = cp.getTitleTextF();
                                    String rating = cp.getRatingTextF();
                                    String calories = cp.getCaloriesTextF();
                                    String protein = cp.getProteinTextF();
                                    String fat = cp.getFatTextF();
                                    String sodium = cp.getSodiumTextF();
                                    String price = cp.getPriceTextF();

                                    admin.modifyProduct(selectedProduct, title, rating, calories, protein, fat, sodium, price);

                                }
                            });

                            cp.createCompositeProductBtnAL(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String compositeProductName = cp.productNameTextF();
                                   CompositeProduct compositeProduct = new CompositeProduct(compositeProductName);
                                   CompositeProductGUI compositeProductGUI = new CompositeProductGUI(admin);
                                   compositeProductGUI.setVisible(true);

                                   compositeProductGUI.doneBtnAL(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent e) {
                                           admin.addNewCompositeProduct(compositeProduct);
                                           compositeProductGUI.setVisible(false);
                                       }
                                   });

                                    compositeProductGUI.selectProductBtnAL(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String title = compositeProductGUI.getComboBoxText2();
                                            Set<BaseProduct> products = admin.getListProducts();
                                            for(BaseProduct b : products){
                                                if(b.getTitle().equals(title)){
                                                    compositeProduct.addNewProduct(b);
                                                }
                                            }

                                        }
                                    });
                                }
                            });

                        }
                    });

                    adminGUI.backToLoginAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            adminGUI.setVisible(false);
                            login.setVisible(true);
                        }
                    });

                    adminGUI.selectReportBtnAL(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String report = adminGUI.getComboBoxText();
                            if(report.equals("Report 1")){
                                Report1GUI report1 = new Report1GUI();
                                report1.setVisible(true);
                                report1.generateBtnAL(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        delivery.generateReport1(report1.startHourTextF(), report1.endHourTextF());
                                    }
                                });
                            }else if(report.equals("Report 2")){
                                Report2GUI report2 = new Report2GUI();
                                report2.setVisible(true);
                                report2.generateBtn(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int number = Integer.parseInt(report2.numberTextF());
                                        delivery.generateReport2(number);
                                    }
                                });
                            }else if(report.equals("Report 3")){
                                Report3GUI report3 = new Report3GUI();
                                report3.setVisible(true);
                                report3.generateBtnAL(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        int number = Integer.parseInt(report3.specifiedNumberTextF());
                                        int amount = Integer.parseInt(report3.specifiedAmountTextF());
                                        delivery.generateReport3(number, amount);
                                    }
                                });
                            }else if(report.equals("Report 4")){
                                Report4GUI report4 = new Report4GUI();
                                report4.setVisible(true);
                                report4.generateBtnAL(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String date = report4.getDayTextF();
                                        delivery.generateRaport4(date);
                                    }
                                });
                            }
                        }
                    });

                }
            }

        });

        login.registerNowAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setVisible(false);
                RegistrationGUI registration = new RegistrationGUI();
                registration.setVisible(true);

                registration.addDoneAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username = registration.getUsernameTextF();
                        String password = String.valueOf(registration.getFirstPass());
                        String confirmedPassword = String.valueOf(registration.getSecondPass());
                        String name = registration.getNameTextF();
                        String address = registration.getAddress();

                        if(password.compareTo(confirmedPassword) == 0){
                            Client newClient = new Client(username, password, name, address);
                            delivery.addNewClient(newClient);
                        }else{
                            JOptionPane.showMessageDialog(null, "The two passwords entered DO NOT MATCH!!!");
                        }

                    }
                });

                registration.addBackAL(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        registration.setVisible(false);
                        login.setVisible(true);
                    }
                });


            }
        });
    }
}
