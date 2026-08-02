        import java.sql.*;
        import java.util.Scanner;

        public class Doctor {

            Connection con = DBConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            public void addDoctor() {

                try {

                    System.out.println("Enter Doctor Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Specialization: ");
                    String specialization = sc.nextLine();
                    sc.nextLine();

                    String sql = "INSERT INTO doctors VALUE(?,?,?)";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, specialization);
                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Doctors Added Successfully.");
                    } else {
                        System.out.println("Doctors Not Added.");
                    }

                    ps.close();
                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            public void viewDoctors() {
                try {
                    Connection con = DBConnection.getConnection();

                    String sql = "SELECT * FROM doctors";

                    Statement st = con.createStatement();

                    ResultSet rs = st.executeQuery(sql);

                    System.out.println("-------------------------------------------------------");
                    System.out.printf("%-10s %-20s %20s%n",
                            "Id", "Name", "Specialization");

                    System.out.println("-------------------------------------------------------");

                    while (rs.next()) {
                        System.out.printf("%-10s %-20s %20s%n",
                                rs.getInt("doctor_id"),
                                rs.getString("name"),
                                rs.getString("specialization"));

                    }
                    rs.close();
                    st.close();
                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void deleteDoctor() {

                System.out.println("Enter Doctor Id to Delete: ");
                int deleteid = sc.nextInt();

                String sql = "DELETE FROM doctors WHERE doctor_id=?";

                try {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, deleteid);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Doctor Deleted Successfully.");
                    } else {
                        System.out.println("Doctor Id Not Found.");
                    }

                    ps.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            public void updateDoctor() {

                try {

                    System.out.println("Enter Doctor Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter New Doctor Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter New Specialization: ");
                    String specialization = sc.nextLine();

                    String sql = "UPDATE doctors SET  name=?, specialization=? WHERE doctor_id=?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setString(1, name);
                    ps.setString(2, specialization);
                    ps.setInt(3, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0) {
                        System.out.println("Doctor UPdate Successfully.");
                    } else {
                        System.out.println("Doctor Id Not Found!");
                    }

                    ps.close();
                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void searchDoctor() {

                try {
                    Connection con = DBConnection.getConnection();

                    System.out.println("Enter Doctor ID: ");
                    int id = sc.nextInt();

                    String sql = "SELECT * FROM doctors WHERE doctor_id=?";

                    PreparedStatement ps = con.prepareStatement(sql);

                    ps.setInt(1, id);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {

                        System.out.println("\n==========Doctor Details===========");
                        System.out.println("Doctor ID           : " + rs.getInt("doctor_id"));
                        System.out.println("Doctor Name         : " + rs.getString("name"));
                        System.out.println("Specialization      : " + rs.getString("specialization"));

                    } else {
                        System.out.println("Doctor Not Found!.");
                    }

                    rs.close();
                    ps.close();
                    con.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
