    import java.sql.*;
    import java.util.Scanner;

    public class Appointment{
        
        Connection con=DBConnection.getConnection();
        Scanner sc=new Scanner(System.in);

        public void bookAppointments(){

            
            try{
                System.out.println("Enter Appointment Id: ");
                int appointmentId=sc.nextInt();
                
                System.out.println("Enter Patient Id: ");
                int patientId=sc.nextInt();

                System.out.println("Enter Doctor Id: ");
                int doctorId=sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Appoinrment Date (YYYY-MM-DD): ");
                String appointmentdate=sc.nextLine();

                String sql = "INSERT INTO appointments VALUE(?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, appointmentId);
                ps.setInt(2, patientId);
                ps.setInt(3, doctorId);
                ps.setString(4, appointmentdate);
                int rows=ps.executeUpdate();

                if(rows>0){
                    System.out.println("Appointment Booked Successfully.");
                }else{
                System.out.println("Appointment Not Booked.");
                }
                
                ps.close();
                con.close();

            }catch(Exception e){
                e.printStackTrace();

            }
            
        }


        public void viewAppointments(){
            
            try{
                Connection con=DBConnection.getConnection();

                String sql = "SELECT a.appointment_id, p.name AS patient_name, d.name AS doctor_name, a.appointment_date "+
                            "FROM appointments a " + 
                            "JOIN patients p ON a.patient_id = p.patient_id " +
                            "JOIN doctors d ON a.doctor_id=d.doctor_id";

            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);

            System.out.println("----------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-15s%n",
                "App ID", "Patient Name", "Doctor Name", "Date");
            System.out.println("----------------------------------------------------------------");

            while(rs.next()){
                    System.out.printf("%-10s %-20s %-20s %-15s%n",
                    rs.getInt("appointment_id"),
                    rs.getString("patient_name"),
                    rs.getString("doctor_name"),
                    rs.getString("appointment_date"));


            }
            rs.close();
            st.close();
            con.close();

            }catch(Exception e){
                e.printStackTrace();
            }
        }


        public void deleteAppointment(){

        System.out.println("Enter Appointment Id to Delete: ");
        int deleteid= sc.nextInt();

        String sql="DELETE FROM appointments WHERE appointment_id=?";

        try{
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,deleteid);

            int rows=ps.executeUpdate();

            if(rows>0){
                System.out.println("Appointment Cancel Successfully.");
            }
            else{
                System.out.println("Appointment Id Not Found.");
            }

            ps.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }



    public void updateAppointment(){

            
            try{
                System.out.println("Enter Appointment Id: ");
                int appointmentId=sc.nextInt();
                
                System.out.println("Enter New Patient Id: ");
                int patientId=sc.nextInt();

                System.out.println("Enter New Doctor Id: ");
                int doctorId=sc.nextInt();
                sc.nextLine();

                System.out.println("Enter New Appoinrment Date (YYYY-MM-DD): ");
                String appointmentdate=sc.nextLine();

                String sql = "UPDATE appointments SET patient_id=?, doctor_id=?, appointment_date=? WHERE appointment_id=?";

                PreparedStatement ps = con.prepareStatement(sql);

                
                ps.setInt(1, patientId);
                ps.setInt(2, doctorId);
                ps.setString(3, appointmentdate);
                ps.setInt(4, appointmentId);

                int rows=ps.executeUpdate();

                if(rows>0){
                    System.out.println("Appointment Update Successfully.");
                }else{
                System.out.println("Appointment Id Not Found!.");
                }
                
                ps.close();
                con.close();

            }catch(Exception e){
                e.printStackTrace();

            }
            
        }


    }