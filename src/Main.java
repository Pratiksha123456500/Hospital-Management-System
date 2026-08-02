
            import java.sql.Connection;
            import java.util.Scanner;

            public class Main{
            public static void main(String args[]){

                    Connection con=DBConnection.getConnection();
                    

                    if(con==null){
                    System.out.println("Database Connection Failed!");
                    return;

                    }
                    
                    Scanner sc = new Scanner(System.in); //user input

                    Patient patient=new Patient();   //objects
                    Doctor doctor =new Doctor();
                    Appointment appointment=new Appointment();

            while(true){



            System.out.println("================================================");
            System.out.println("           HOSPITAL MANAGEMENT SYSTEM            ");
            System.out.println("================================================");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Search Patient");
            System.out.println("5. Update Patient");

            System.out.println("------------------------------------------------");

            System.out.println("6. Add Doctor");
            System.out.println("7. View Doctors");
            System.out.println("8. Delete Doctor");
            System.out.println("9. Search Doctor");
            System.out.println("10. Update Doctor");

            System.out.println("------------------------------------------------");

            System.out.println("11. Book Appointment");
            System.out.println("12. View Appointments");
            System.out.println("13. Update Appointment");
            System.out.println("14. Cancle Appointment");

            System.out.println("------------------------------------------------");

            System.out.println("15. Exit");

            System.out.println("================================================");

            System.out.print("Enter Your choice: ");
            int choice=sc.nextInt();


            switch(choice){
            case 1:
                patient.addPatient();
                break;

            case 2:
                patient.viewPatients();
                break;

            case 3:
                patient.deletePatient();
                break;

            case 4:
                patient.searchPatient();
                break;

            case 5:
                patient.updatePatient();
                break;


            case 6:
                doctor.addDoctor();
                break;

                case 7:
                doctor.viewDoctors();
                break;

            case 8:
                doctor.deleteDoctor();
                break;
                
            case 9:
                doctor.searchDoctor();
                break;

            case 10:
                doctor.updateDoctor();
                break;

            case 11:
                appointment.bookAppointments();
                break;

            case 12:
                appointment.viewAppointments();
                break;

            case 13:
                appointment.updateAppointment();
                break;

            case 14:
                appointment.deleteAppointment();
                break; 

            case 15:
                try{
                    con.close();
                    sc.close();
                }catch(Exception e){
                    e.printStackTrace();

                }
                System.out.println("Thank You for Using \nHospital Management System \nVisit Again.");
                System.exit(0);
                
                sc.close();
                return;
                

            default:
                System.out.println("Invalid Choice! \nPlease Emter a Number Between 1 and 13.");
                }   
            } 
                
            }
            }




