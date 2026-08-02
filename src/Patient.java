
                    import java.sql.*;
                    import java.util.Scanner;



                    public class Patient{

                        Connection con = DBConnection.getConnection();
                        Scanner sc=new Scanner(System.in);

                        public void addPatient(){

                            
                            try{
                            System.out.println("Enter Patient Id: ");
                            int id=sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter Name: ");
                            String name=sc.nextLine();

                            System.out.println("Enter Age: ");
                            int age=sc.nextInt();
                            sc.nextLine();
                            
                            System.out.println("Enter  Gender: ");
                            String gender=sc.nextLine();

                            System.out.println("Enter phone: ");
                            String phone=sc.nextLine();
                            
                            String sql = "INSERT INTO patients(patient_id,name,age,gender,phone) VALUE(?,?,?,?,?)";

                            PreparedStatement ps=con.prepareStatement(sql);

                            ps.setInt(1, id);
                            ps.setString(2, name);
                            ps.setInt(3, age);
                            ps.setString(4, gender);
                            ps.setString(5, phone);

                            int rows = ps.executeUpdate();

                            if(rows > 0){
                                System.out.println("Patient Added Successfully.");
                            }
                            else{
                                System.out.println("Patient Not Added.");
                            }
                            
                            ps.close();
                            con.close();
                    
                        }catch(Exception e){
                            e.printStackTrace();

                        }
                            
                        }
                        







                        public void viewPatients(){
                            try{
                                Connection con=DBConnection.getConnection();

                                String sql = "SELECT * FROM patients";

                                Statement st = con.createStatement();

                                ResultSet rs = st.executeQuery(sql);

                                System.out.println("-----------------------------------------------------------");
                                System.out.printf("%-10s %-20s %-5s %-10s %-15s%n",
                                    "Id", "Name", "Age", "Gender", "Phone"); 
                                
                                System.out.println("------------------------------------------------------------");

                                while(rs.next()){
                                    System.out.printf("%-10s %-20s %-5s %-10s %-15s%n",
                                        rs.getInt("patient_id"),
                                        rs.getString("name"),
                                        rs.getInt("age"),
                                        rs.getString("gender"),
                                        rs.getString("phone"));
                                    
                                }
                                rs.close();
                                st.close();
                                con.close();
                            }catch(Exception e){
                                e.printStackTrace();

                            }
                            
                        }






                    public void deletePatient(){

                        System.out.println("Enter Patient Id to Delete: ");
                        int deleteid= sc.nextInt();

                        String sql="DELETE FROM patients WHERE patient_id=?";

                        try{
                            PreparedStatement ps=con.prepareStatement(sql);
                            ps.setInt(1,deleteid);

                            int rows=ps.executeUpdate();

                            if(rows>0){
                                System.out.println("Patient Deleted Successfully.");
                            }
                            else{
                                System.out.println("Patient Id Not Found.");
                            }

                            ps.close();

                        }catch(SQLException e){
                            e.printStackTrace();
                        }

                    }






                    public void updatePatient(){

                        try{
                            Connection con=DBConnection.getConnection();
                            
                            System.out.println("Enter Patient ID:");
                            int id=sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter New Name:");
                            String name=sc.nextLine();

                            System.out.println("Enter New Age:");
                            int age=sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter New Gender:");
                            String gender=sc.nextLine();
                            

                            System.out.println("Enter New Phone:");
                            String phone=sc.nextLine();
                            

                            String sql = "UPDATE patients SET name=?, age=?, gender=?, phone=? WHERE patient_id=?";

                            PreparedStatement ps=con.prepareStatement(sql);

                            
                            ps.setString(1,name);
                            ps.setInt(2,age);
                            ps.setString(3,gender);
                            ps.setString(4,phone);
                            ps.setInt(5,id);
                            

                            int rows=ps.executeUpdate();

                            if(rows>0){
                                System.out.println("Patient Update Successfully");
                            }
                            else{
                                System.out.println("Patient Id Not Found!");
                            }
                            ps.close();
                            con.close();

                            
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    





                    public void searchPatient(){

                        try{
                            Connection con=DBConnection.getConnection();

                            System.out.println("Enter Patient ID: ");
                            int id=sc.nextInt();

                            String sql = "SELECT * FROM patients WHERE patient_id=?";

                            PreparedStatement ps = con.prepareStatement(sql);

                            ps.setInt(1,id);

                            ResultSet rs= ps.executeQuery();

                            if(rs.next()){

                                System.out.println("\n==========Patient Details===========");
                                System.out.println("Patient ID           : "+rs.getInt("patient_id"));
                                System.out.println("Patient Name         : "+rs.getString("name"));
                                System.out.println("Patient Age          : "+rs.getInt("age"));
                                System.out.println("Patient Gender       : "+rs.getString("gender"));
                                System.out.println("Patient Phone Number : "+rs.getString("phone"));
                            }else{
                                System.out.println("Patient Not Found!.");
                            }

                            rs.close();
                            ps.close();
                            con.close();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }


                        
                    }