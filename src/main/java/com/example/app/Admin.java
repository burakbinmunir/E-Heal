package com.example.app;


import com.example.app.Appointments.DoctorAppointment;
import com.example.app.Appointments.PatientAppointment;
import com.example.app.Appointments.TempObservation;
import com.example.app.HealthServiceProvider.Order;
import com.example.app.HealthServiceProvider.Pharmacy;
import com.example.app.PatientPackage.LabTest;
import com.example.app.PatientPackage.MedicalRecord;
import com.example.app.PatientPackage.Medicine;
import com.example.app.PatientPackage.Prescription;
import com.example.app.System.FirstAid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import org.apache.commons.compress.harmony.pack200.NewAttributeBands;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Admin {
   private Connection con;

   public Admin() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost/eheal", "root", "Highschoolprince1");
        }
        catch (ClassNotFoundException exception) {
            Notification.show("Class not found exception occured");
        } catch (SQLException exception) {
            Notification.show("Sql Connection not established");
        }
    }

    public void logout(){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call logOutCurrentUser()}");
               stmt.execute();
           }
           catch (SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void setCurrentsUser(String currentUser){
       if (con != null){
           try{
               CallableStatement stmt = con.prepareCall("{call setCurrentUser(?)}");
               stmt.setString(1,currentUser);
               stmt.execute();
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }

    }

    public String getCurrentUser(){
        if (con != null){
            try{
                CallableStatement stmt = con.prepareCall("{call getCurrentUser()}");
                ResultSet rs = stmt.executeQuery();
                return rs.getString("currentUser");
            }

            catch (SQLException exception){
                Notification.show(exception.getMessage());
            }
        }
        return null;
    }

    public void setTempDoc(String registrationNumber){
        if (con!=null){
            try{
                CallableStatement stmt = con.prepareCall("call setTempDoc(?)");
                stmt.setString(1,registrationNumber);
                stmt.execute();
            }
            catch (SQLException exception){
                Notification.show(exception.getMessage());
            }
        }
    }

    public String getTempDoc(){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("call getTempDoc()");

               ResultSet rs = stmt.executeQuery();
               return rs.getString("registrationNumber");
           }
           catch (SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public void removeTempDoc(){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call removeTempDoc()}");
               stmt.execute();
           }

           catch (SQLException exception){
               exception.getMessage();
           }
       }
    }

    public void bookAppointment(Time startTime, Time endTime, Date date, String currentCondition){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call bookAppointment(?,?,?,?)}");
               stmt.setTime(1, startTime);
               stmt.setTime(2, endTime);
               stmt.setDate(3, date);
               stmt.setString(4,currentCondition);
               stmt.execute();
           }

           catch (SQLException exception){
               Notification.show(exception.getMessage());
           }
       }


    }

    public Patient verifyPatient(String userName, String password){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call loginPatient(?,?)}");

               stmt.setString(1,userName);
               stmt.setString(2,password);
               ResultSet rs = stmt.executeQuery();
               if (rs.next()){
                   Patient newPatient = new Patient();
                   String h = rs.getString("FirstName");
                   newPatient.setFirstName(rs.getString("FirstName"));
                   newPatient.setLastName(rs.getString("LastName"));
                   newPatient.setUsername(rs.getString("UserName"));
                   newPatient.setPassword(rs.getString("Password"));
                   newPatient.setCNIC(rs.getString("CNIC"));
                   newPatient.setPhoneNumber(rs.getString("PhoneNumber"));
                   newPatient.setEmail(rs.getString("Email"));
                   newPatient.setDateOfBirth(rs.getDate("DateOfBirth"));
                   newPatient.setGender(rs.getString("Gender"));
                   newPatient.setSecurityQuestion(rs.getString("SecurityQuestion"));
                   newPatient.setAnswerToSecurityQuestion(rs.getString("SecurityAnswer"));
                   newPatient.setID(rs.getInt("ID"));

                   CallableStatement stmt1 = con.prepareCall("call logOutCurrentUser()");
                   stmt1.execute();

                   CallableStatement stmt2 = con.prepareCall("{call setCurrentUser(?)}");
                   stmt2.setString(1,userName);
                   stmt2.execute();
                   stmt2.close();
                   stmt.close();
                   return newPatient;
               }

           }
           catch (SQLException exception){
               Notification.show("Cannot Login Patient");
           }
       }
       return null;
    }

    public void enrollPatient(String userName, String password, String firstName, String lastName, String phoneNumber, String email, String gender, Date DOB,String CNIC,String securityQuestion, String answerToSQ){
        if (con != null){
            try {
                CallableStatement statement = con.prepareCall("{call SignUpAsPatient(?,?,?,?,?,?,?,?,?,?,?)}");
                statement.setString(1,userName);
                statement.setString(2,password);
                statement.setString(3,firstName);
                statement.setString(4,lastName);
                statement.setString(5,CNIC);
                statement.setString(6,phoneNumber);
                statement.setString(7,email);
                statement.setDate(8,DOB);
                statement.setString(9,gender);
                statement.setString(10,securityQuestion);
                statement.setString(11,answerToSQ);
                statement.execute();
                statement.close();
            }
            catch(SQLException exception){
                exception.printStackTrace();
            }

        }
    }

    public void placeOrder(String regNum){
       if (con != null){
           try{
               CallableStatement stmt = con.prepareCall("{call placeOrder(?)}");
               stmt.setString(1,regNum);
               stmt.execute();
               stmt.close();
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void setTempPrescription(int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{ call addTempPrescription(?)}");
               stmt.setInt(1,appNum);
               stmt.execute();
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public Pharmacy pharmacyLogin(String regNum, String password){
       if (con!=null){
           try{
               CallableStatement statement = con.prepareCall("{call loginPharmacy(?,?)}");
               statement.setString(1,regNum);
               statement.setString(2,password);
               ResultSet rs = statement.executeQuery();
               Pharmacy newPharmacy = null;
               if (rs.next()){
                   CallableStatement stmt = con.prepareCall("{call setCurrentPharmacy(?)}");
                    newPharmacy = new Pharmacy();
                   newPharmacy.setRegistrationNumber(rs.getString("registrationNumber"));
                   stmt.setString(1,newPharmacy.getRegistrationNumber());
                   stmt.execute();
                   stmt.close();
               }
               statement.close();
               rs.close();
               return newPharmacy;

           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

   public List<Pharmacy> getAvailablePharmacies(){
       if (con!= null){
           try{
               CallableStatement statement = con.prepareCall("{call getAvailablePharmacies()}");
               ResultSet rs = statement.executeQuery();
//    id int primary key auto_increment,
//    hspName nvarchar(50) not null,
//    registrationNumber nvarchar(50)not null unique ,
//    address nvarchar(50) not null,
//    phoneNumber nvarchar(50) not null ,
//    password nvarchar(50)not null,
//    email nvarchar(50)not null,
               List<Pharmacy> availablePharmacies = new ArrayList<Pharmacy>();
               while (rs.next()){
                   Pharmacy newPharmacy = new Pharmacy();
                   newPharmacy.setName(rs.getString("hspName"));
                   newPharmacy.setEmail(rs.getString("email"));
                   newPharmacy.setAddress(rs.getString("address"));
                   newPharmacy.setPhone(rs.getString("phoneNumber"));
                   newPharmacy.setRegistrationNumber(rs.getString("registrationNumber"));
                   availablePharmacies.add(newPharmacy);
               }
               statement.close();
               rs.close();
               return availablePharmacies;
           }
           catch (SQLException ex){
               Notification.show(ex.getMessage());
           }
       }
       return null;
   }

   public void setAvailable(String medName){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call setAvailable(?)}");
               stmt.setString(1,medName);
               stmt.execute();
               stmt.close();

           }

           catch (SQLException ex){
               Notification.show(ex.getMessage());
           }
       }
   }

   public void setCurrentOrder(int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call setCurrentOrder(?)}");
               stmt.setInt(1,appNum);
               stmt.close();
           }
           catch (SQLException ex){
               Notification.show(ex.getMessage());
           }
       }
   }

   public List<Order> getOrders(){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call getOrders()}");
               ResultSet rs = stmt.executeQuery();
               List<Order> orders = new ArrayList<Order>();
               while (rs.next()){
                  Order ord = new Order();
                  ord.setAppNum(rs.getInt("appNum"));
                  ord.setOrderNumber(rs.getInt("orderNum"));

                   CallableStatement stmt2 = con.prepareCall("call getMedcinesByAppNum(?)");
                   stmt2.setInt(1,ord.getAppNum());
                   ResultSet result = stmt2.executeQuery();
                   List<Medicine> foundMedicines = new ArrayList<Medicine>();

                   while (result.next())
                   {
                       Medicine newMedicine = new Medicine();
                       newMedicine.setMedicineName(result.getString("medicineName"));
                       newMedicine.setDoseInMorning(result.getDouble("doseInMorning"));
                       newMedicine.setDoseInNoon(result.getDouble("doseInNoon"));
                       newMedicine.setDoseInNight(result.getDouble("doseInNight"));
                       foundMedicines.add(newMedicine);
                   }
                   ord.setPrescribedMedicines(foundMedicines);
                   orders.add(ord);
               }
               return orders;
           }

           catch(SQLException ex){
               Notification.show(ex.getMessage());
           }
       }
       return null;
   }

    public List<FirstAid> viewFirstAid() {

        if (con != null) {
            try {
                CallableStatement stmt = con.prepareCall("{call viewFirstAid()}");
                ResultSet rs = stmt.executeQuery();
                List<FirstAid> firstaid = new ArrayList<FirstAid>();
                while (rs.next()) {
                    FirstAid aid = new FirstAid();
                    aid.setIncidentName(rs.getString("incident"));
                    aid.setMeasureLink(rs.getString("measureLink"));
                    firstaid.add(aid);
                }
                return firstaid;
            } catch (SQLException exception) {
                Notification.show(exception.getMessage());
            }
        }
        return null;
    }

    public List<MedicalCentre> getMedicalCentres(String regNumber){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call getMedicalCentres(?)}");
               stmt.setString(1,regNumber);
               ResultSet rs = stmt.executeQuery();
               List<MedicalCentre> allMedicalCentres = new ArrayList<MedicalCentre>();
               while(rs.next()){
                    MedicalCentre medicalCentre = new MedicalCentre();
                    medicalCentre.setName(rs.getString("CentreName"));
                    medicalCentre.setAddress(rs.getString("CentreAddress"));
                    medicalCentre.setType(rs.getString("CentreType"));
                    medicalCentre.setStartTime(rs.getTime("StartTime"));
                    medicalCentre.setEndTime(rs.getTime("EndTime"));
                    allMedicalCentres.add(medicalCentre);
               }
                return allMedicalCentres;
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public String getPatientName(String userName){
       if(con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call getPatientNamebyUserName(?)}");
               stmt.setString(1,userName);
               ResultSet rs = stmt.executeQuery();

               if (rs.next()){
                   return rs.getString("FirstName") + rs.getString("LastName");
               }
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public void rescheduleAppointment(int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call reshecduleAppointment(?)}");
               stmt.setInt(1,appNum);
               stmt.execute();
               stmt.close();
               Notification.show("Reschedle Request Sent!!").addThemeVariants(NotificationVariant.LUMO_SUCCESS);
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void approveAppointment(int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("call approveAppointment(?)");
               stmt.setInt(1,appNum);
               stmt.execute();
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }

    }

    public List<PatientAppointment> getCurretnDoctorAppointments() {

       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call getCurrentDoctorsAppointments()}");
               ResultSet rs = stmt.executeQuery();

               List<PatientAppointment> foundAppointments = new ArrayList<PatientAppointment>();
               while(rs.next()){
                   PatientAppointment patientAppointment = new PatientAppointment();
                   patientAppointment.setAppointmentNumber(rs.getInt("appointmentNumber"));
                   patientAppointment.setStatus(rs.getInt("status"));
                   patientAppointment.setStartTime(rs.getTime("endTime"));
                   patientAppointment.setEndTime(rs.getTime("startTime"));
                   patientAppointment.setDate(rs.getDate("date"));
                   patientAppointment.setPatientsCurrentCondition(rs.getString("currentCondition"));
                   patientAppointment.setPatientUserName(rs.getString("patientUserName"));
                   foundAppointments.add(patientAppointment);
               }
               return foundAppointments;
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public List<PatientAppointment> getApprovedAppointments(){
        if (con!=null){
            try{
                CallableStatement stmt = con.prepareCall("{call getApprovedAppointments()}");
                ResultSet rs = stmt.executeQuery();

                List<PatientAppointment> foundAppointments = new ArrayList<PatientAppointment>();
                while(rs.next()){
                    PatientAppointment patientAppointment = new PatientAppointment();
                    patientAppointment.setAppointmentNumber(rs.getInt("appointmentNumber"));
                    patientAppointment.setStatus(rs.getInt("status"));
                    patientAppointment.setStartTime(rs.getTime("endTime"));
                    patientAppointment.setEndTime(rs.getTime("startTime"));
                    patientAppointment.setDate(rs.getDate("date"));
                    patientAppointment.setPatientsCurrentCondition(rs.getString("currentCondition"));
                    patientAppointment.setPatientUserName(rs.getString("patientUserName"));
                    foundAppointments.add(patientAppointment);
                }
                return foundAppointments;
            }
            catch(SQLException exception){
                Notification.show(exception.getMessage());
            }
        }
        return null;
    }

    public Doctor verifyDoctor(String userName, String password){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call loginDoctor(?,?)}");
               stmt.setString(1,userName);
               stmt.setString(2,password);
               ResultSet rs = stmt.executeQuery();

               Doctor doc = new Doctor();
               if (rs.next()){
                   doc.setFirstName(rs.getString("FirstName"));
                   doc.setLastName(rs.getString("LastName"));
                   doc.setCNIC(rs.getString("CNIC"));
                   doc.setPhoneNumber(rs.getString("PhoneNumber"));
                   doc.setEmail(rs.getString("Email"));
                   doc.setDateOfBirth(rs.getDate("DateOfBirth"));
                   doc.setGender(rs.getString("Gender"));
                   doc.setUsername(rs.getString("UserName"));
                   doc.setPassword(rs.getString("Password"));
                   doc.setSecurityQuestion(rs.getString("SecurityQuestion"));
                   doc.setAnswerToSecurityQuestion(rs.getString("SecurityAnswer"));
                   doc.setRegistrationNumber(rs.getString("RegistrationNumber"));
                   doc.setSpecialization(rs.getString("Specialization"));

                   CallableStatement stmt2 = con.prepareCall("{call setCurrentDoctor(?)}");
                   stmt2.setString(1,userName);
                   stmt2.execute();
                   stmt.close();
                   stmt2.close();
                   return doc;
               }
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }

       }
       return null;
    }

    public List<MedicalRecord> getMedicalRecord(){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call getMedicalRecords()}");
               ResultSet rs = stmt.executeQuery();
               List<MedicalRecord> foundRecords = new ArrayList<MedicalRecord>();
               while(rs.next()){

                 MedicalRecord mr = new MedicalRecord();
                 mr.setDiseaseName(rs.getString("diseaseName"));
                 mr.setOccurenceMonth(rs.getInt("occurenceMonth"));
                 mr.setOccurenceYear(rs.getInt("occurenceYear"));
                 mr.setCurrentCondition(rs.getString("status"));
                 foundRecords.add(mr);
               }
               stmt.close();
               return foundRecords;
           }


           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public void addMedicalRecord(String diseaseName, int occurYear, int occurMonth, String status){
       if (con!=null){
           try{
            CallableStatement stmt = con.prepareCall("{call addMedicalRecord(?,?,?,?)}");
            stmt.setString(1,diseaseName);
            stmt.setInt(2,occurYear);
            stmt.setInt(3,occurMonth);
            stmt.setString(4,status);
            stmt.execute();
            stmt.close();
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void removeUnderObservation(){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call removeUnderObservation()}");
               stmt.execute();
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void cancelAppointment(int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call cancelAppointment(?)}");
               stmt.setInt(1,appNum);
               stmt.execute();
               stmt.close();
           }


           catch(SQLException ex){
               Notification.show(ex.getMessage());
           }
       }
    }

    public TempObservation getUnderObservation(){
            if (con!=null){
             try{
                 CallableStatement stmt = con.prepareCall("{call getUnderObservation()}");
                 ResultSet rs = stmt.executeQuery();
                 if (rs.next()){
                    TempObservation to = new TempObservation();

                      to.setDocName(rs.getString("doctorName"));
                     to.setDocSpecialization(rs.getString("docSpecialization"));
                     to.setPhoneNumber(rs.getString("phoneNumber"));
                     to.setDocEmail(rs.getString("email"));
                     to.setDocGender(rs.getString("gender"));
                     to.setHealthCentreName(rs.getString("healthcentre"));
                     to.setDate(rs.getDate("appointmentDate"));
                     to.setStartTime(rs.getTime("startTime"));
                     to.setEndTime(rs.getTime("endTime"));
                     to.setStatus(rs.getInt("status"));
                     to.setAppNum(rs.getInt("appNum"));
                     return to;
                 }
                 rs.close();
                 stmt.close();
             }

             catch (SQLException exception){
                 Notification.show(exception.getMessage() +"While Getting Out");
             }
            }
            return null;
    }

    public void keepUnderObservation(String docName, String docSpecialization, String phoneNumber,String docEmail,String docGender, String healthCentreName, Date appDate, Time startTime, Time endTime,int status,int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call keepUnderObservation(?,?,?,?,?,?,?,?,?,?,?)}");
                stmt.setString(1,docName);
                stmt.setString(2,docSpecialization);
                stmt.setString(3,phoneNumber);
                stmt.setString(4,docEmail);
                stmt.setString(5,docGender);
                stmt.setString(6,healthCentreName);
                stmt.setDate(7,appDate);
                stmt.setTime(8,startTime);
                stmt.setTime(9,endTime);
                stmt.setInt(10,status);
                stmt.setInt(11,appNum);
                stmt.execute();
                stmt.close();
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public List<Doctor> searchBySpecialization(String specialization){
       if (con != null){
           try{
               CallableStatement stmt = con.prepareCall("{call searchDoctorBySpecialization(?)}");
               stmt.setString(1,specialization);
               ResultSet rs = stmt.executeQuery();
               List<Doctor> foundDoctors = new ArrayList<Doctor>();
               while(rs.next()){
                   Doctor doc = new Doctor();
                   doc.setFirstName(rs.getString("FirstName"));
                   doc.setLastName(rs.getString("LastName"));
                   doc.setCNIC(rs.getString("CNIC"));
                   doc.setPhoneNumber(rs.getString("PhoneNumber"));
                   doc.setEmail(rs.getString("Email"));
                   doc.setDateOfBirth(rs.getDate("DateOfBirth"));
                   doc.setGender(rs.getString("Gender"));
                   doc.setUsername(rs.getString("UserName"));
                   doc.setPassword(rs.getString("Password"));
                   doc.setSecurityQuestion(rs.getString("SecurityQuestion"));
                   doc.setAnswerToSecurityQuestion(rs.getString("SecurityAnswer"));
                   doc.setRegistrationNumber(rs.getString("RegistrationNumber"));
                   doc.setSpecialization(rs.getString("Specialization"));
                   foundDoctors.add(doc);
               }
               stmt.close();
               rs.close();
               return foundDoctors;

           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public Doctor getDoctorByRegistrationNumber(String regNumber){
       if (con!=null){
           try{
               CallableStatement stmt1 = con.prepareCall("{call getDoctorNameByRegistrationNumber(?)}");
               stmt1.setString(1,regNumber);
               ResultSet rs = stmt1.executeQuery();
               if (rs.next()) {
                   Doctor doc = new Doctor();
                   doc.setFirstName(rs.getString("FirstName"));
                   doc.setLastName(rs.getString("LastName"));
                   doc.setCNIC(rs.getString("CNIC"));
                   doc.setPhoneNumber(rs.getString("PhoneNumber"));
                   doc.setEmail(rs.getString("Email"));
                   doc.setDateOfBirth(rs.getDate("DateOfBirth"));
                   doc.setGender(rs.getString("Gender"));
                   doc.setUsername(rs.getString("UserName"));
                   doc.setPassword(rs.getString("Password"));
                   doc.setSecurityQuestion(rs.getString("SecurityQuestion"));
                   doc.setAnswerToSecurityQuestion(rs.getString("SecurityAnswer"));
                   doc.setRegistrationNumber(rs.getString("RegistrationNumber"));
                   doc.setSpecialization(rs.getString("Specialization"));
                   return doc;
               }
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public List<DoctorAppointment> getDoctorAppointments(){
       if (con!=null){
           try{

               CallableStatement stmt = con.prepareCall("{call getDoctorAppointments()}");
               ResultSet rs = stmt.executeQuery();

               List<DoctorAppointment> doctorAppointments = new ArrayList<>();

               while (rs.next()){
                   DoctorAppointment doctorAppointment = new DoctorAppointment();
                   doctorAppointment.setAppointmentNumber(rs.getInt("appointmentNumber"));
                   doctorAppointment.setStatus(rs.getInt("status"));
                   doctorAppointment.setStartTime(rs.getTime("endTime"));
                   doctorAppointment.setEndTime(rs.getTime("startTime"));
                   doctorAppointment.setDate(rs.getDate("date"));
                   doctorAppointment.setCurrentCondition(rs.getString("currentCondition"));
                   String regNumber  = rs.getString("registrationNumber");
                   doctorAppointment.setDoctor(getDoctorByRegistrationNumber(regNumber));
                   doctorAppointments.add(doctorAppointment);
               }
               rs.close();
               stmt.close();
               return doctorAppointments;
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
       return null;
    }

    public void addPrescription(String diseaseName, String doctorComment,int duration){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call addPrescription(?,?,?)}");
               stmt.setString(1,diseaseName);
               stmt.setString(2,doctorComment);
               stmt.setInt(3,duration);
               stmt.execute();
               stmt.close();
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void addAppointmentBeingDiagnosed(int appNum){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call addAppointmentBeingDiagnosed(?)}");
               stmt.setInt(1,appNum);
               stmt.execute();
               stmt.close();
           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public List<Prescription> getPrescriptions(){
        if (con!=null){
            try{
                CallableStatement stmt = con.prepareCall("{call getPrescriptionOfCurrentUser()}");
                ResultSet rs = stmt.executeQuery();

                List<Prescription> foundPrescriptions = new ArrayList<Prescription>();


                while(rs.next()){
                    Prescription prescription = new Prescription();
                    prescription.setDuration(rs.getInt("duration"));
                    prescription.setPrescribedDate(rs.getDate("prescribedDate"));
                    prescription.setDoctorComment(rs.getString("doctorComment"));
                    prescription.setDoctorName(rs.getString("doctorName"));
                    prescription.setAppointmentNumber(rs.getInt("appointmentNumber"));

                    List<Medicine> prescribedMedicines = new ArrayList<Medicine>();
                    CallableStatement stmt2 = con.prepareCall("{call getMedcinesByAppNum(?)}");
                    stmt2.setInt(1,prescription.getAppointmentNumber());
                    ResultSet rs2 = stmt2.executeQuery();
                    while(rs2.next()){
                        Medicine newMedicine = new Medicine();
                        newMedicine.setMedicineName(rs2.getString("medicineName"));
                        newMedicine.setDoseInMorning(rs2.getDouble("doseInMorning"));
                        newMedicine.setDoseInNoon(rs2.getDouble("doseInNoon"));
                        newMedicine.setDoseInNight(rs2.getDouble("doseInNight"));
                        prescribedMedicines.add(newMedicine);
                    }

                    List<LabTest> labTests = new ArrayList<LabTest>();
                    CallableStatement stmt3 = con.prepareCall("{call getLabTestByAppNum(?)}");
                    stmt3.setInt(1,prescription.getAppointmentNumber());
                    ResultSet rs3 = stmt3.executeQuery();
                    while(rs3.next()){
                        LabTest newLabTest = new LabTest();
                        newLabTest.setLabTestName(rs3.getString("labTestName"));
                        newLabTest.setLabTestNumber(rs3.getInt("labTestNumber"));
                        labTests.add(newLabTest);
                    }

                    prescription.setRecommendedTests(labTests);
                    prescription.setPrescribedMedicines(prescribedMedicines);

                    foundPrescriptions.add(prescription);
                    rs3.close();
                    rs2.close();
                    stmt2.close();
                    stmt3.close();
                }
                return foundPrescriptions;
            }
            catch(SQLException exception){
                Notification.show(exception.getMessage());
            }
        }
        return null;
    }

    public void addMedicine(String medicineName, double morningDose, double noonDose, double nightDose){
       if (con!=null){
           try{

               CallableStatement stmt = con.prepareCall("{call addMedicine(?,?,?,?)}");
               stmt.setString(1,medicineName);
               stmt.setDouble(2,morningDose);
               stmt.setDouble(3,noonDose);
               stmt.setDouble(4,nightDose);
               stmt.execute();
               stmt.close();

           }
           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void addLabTest(String labTestName){
       if (con!=null){
           try{
               CallableStatement stmt= con.prepareCall("{call addLabTest(?)}");
               stmt.setString(1,labTestName);
               stmt.execute();
               stmt.close();
           }

           catch(SQLException exception ){
               Notification.show("Medicine Cannot Be Added" + exception.getLocalizedMessage());
           }
       }
    }

    public List<Doctor> getDoctors(String firstName, String lastName){
       if (con != null){
           try{
               CallableStatement statement = con.prepareCall("call getDoctorsByName(?,?)");
               statement.setString(1,firstName);
               statement.setString(2,lastName);
               ResultSet rs = statement.executeQuery();
               List<Doctor> foundDoctors = new ArrayList<Doctor>();

               while (rs.next()){
                    Doctor d = new Doctor();
                    d.setFirstName(rs.getString("FirstName"));
                    d.setLastName(rs.getString("LastName"));
                    d.setPhoneNumber(rs.getString("PhoneNumber"));
                    d.setEmail(rs.getString("Email"));
                    d.setPassword(rs.getString("Password"));
                    d.setUsername(rs.getString("UserName"));
                    d.setCNIC(rs.getString("CNIC"));
                    d.setDateOfBirth(rs.getDate("DateOfBirth"));
                    d.setGender(rs.getString("Gender"));
                    d.setRegistrationNumber(rs.getString("RegistrationNumber"));
                    d.setSpecialization(rs.getString("Specialization"));
                    d.setSecurityQuestion(rs.getString("SecurityQuestion"));
                    d.setAnswerToSecurityQuestion(rs.getString("SecurityAnswer"));
                    foundDoctors.add(d);
               }
               statement.close();
               rs.close();
               return foundDoctors;
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
        return null;
    }

    public Vector<String> getAvailableDoctors(){
       if (con != null) {
           try {
               CallableStatement stmt = con.prepareCall("{call getDoctorNames()}");
               ResultSet rs = stmt.executeQuery();
               Vector<String> doctorNames = new Vector<String>();
               while(rs.next()){
                   doctorNames.add(rs.getString("FirstName") + " " +rs.getString("LastName"));
               }
               stmt.close();
               return doctorNames;
           }

           catch (SQLException exception){
               Notification.show("Cannot Show Doctors");
           }

       }
        return null;
    }

    void enrollDoctor(String registrationNumber, String specialization,String userName){
       if (con != null){
           try{
               CallableStatement stmt = con.prepareCall("call signUpAsDoctor(?,?,?)");
               stmt.setString(1,registrationNumber);
               stmt.setString(2,specialization);
               stmt.setString(3,userName);
               stmt.execute();
               stmt.close();
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public Vector<String> getSpecializations(){
       if (con != null){
           try{

               CallableStatement stmt = con.prepareCall("{call getSpecializations()}");
               ResultSet rs = stmt.executeQuery();
               Vector<String> specilizations = new Vector<String>();
               while(rs.next()){
                   specilizations.add(rs.getString("specializationName"));
               }

               return specilizations;
           }

           catch(SQLException exception){
               Notification.show("Can't Get Specializations");
           }
       }
       return null;
    }

    public void addNewSpecialization(String newSpecialization){
       if (con != null){
           try {
               CallableStatement stmt = con.prepareCall("{call addNewSpecialization(?)}");
               stmt.setString(1, newSpecialization);
               stmt.execute();
               stmt.close();
           }
           catch(SQLException exception){
               Notification.show("Can't Add New Specialization");
           }
       }
    }

    public void addMedicalCentre( String medName, String medAddress, String medType , Time startTime, Time endTime){
       if (con!=null){
           try {
               CallableStatement stmt = con.prepareCall("{call addNewMedicalCentre(?,?,?,?,?)}");
               stmt.setString(1,medName);
               stmt.setString(2,medAddress);
               stmt.setString(3,medType);
               stmt.setTime(4,startTime);
               stmt.setTime(5,endTime);
               stmt.execute();
               stmt.close();
           }

           catch(SQLException exception){
               Notification.show(exception.getMessage());
           }
       }
    }

    public void addTempReg(String reg){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("call storeTempRegnum(?)");
               stmt.setString(1,reg);
               stmt.execute();
               stmt.close();
           }

           catch (SQLException exception){
               Notification.show(exception.getMessage());
           }

       }
    }

    public void addDegree(String docRegistrationNumber, String degreeName, int completionYear, String institute){
       if (con!=null){
           try {
               CallableStatement stmt = con.prepareCall("{call addDoctorDegree(?,?,?)}");
               stmt.setString(1,degreeName);
               stmt.setInt(2,completionYear);
               stmt.setString(3,institute);
               stmt.setString(3,institute);
               stmt.execute();
               stmt.close();
           }

           catch(SQLException exception){
               Notification.show("Cannot add more Degree");
           }
       }
    }

    public void enrollPharmacy(String name, String registrationNumber, String address,String password,String phoneNumber,String email){
       if (con != null){
           try{
                CallableStatement stmt = con.prepareCall("{call signupAsPharmacy(?,?,?,?,?,?)}");
                stmt.setString(1,name);
                stmt.setString(2,address);
                stmt.setString(3,registrationNumber);
                stmt.setString(4,password);
                stmt.setString(5,phoneNumber);
                stmt.setString(6,email);
                stmt.execute();
                stmt.close();
           }
           catch(SQLException exception){
               Notification.show("Cannot Enroll Pharmacy");
           }
       }
    }

    public void deletePharmacy(String registrationNumber){
       if (con!=null){
           try{
               CallableStatement stmt = con.prepareCall("{call deletePharmacy(?)}");
               stmt.setString(1,registrationNumber);
           }

           catch (SQLException  exception){
               Notification.show("Cannot Delete Pharmacy");
           }
       }
    }

    public void deleteLaboratroy(String registrationNumber){
        if (con!=null){
            try{
                CallableStatement stmt = con.prepareCall("{call deleteLaboratory(?)}");
                stmt.setString(1,registrationNumber);
            }

            catch (SQLException  exception){
                Notification.show("Cannot Delete Pharmacy");
            }
        }
    }

    public void enrollLaboratory(String name, String registrationNumber, String address,String password,String phoneNumber,String email){
        if (con != null){
            try{
                CallableStatement stmt = con.prepareCall("{call signupAsLaboratory(?,?,?,?,?,?)}");
                stmt.setString(1,name);
                stmt.setString(2,address);
                stmt.setString(3,registrationNumber);
                stmt.setString(4,password);
                stmt.setString(5,phoneNumber);
                stmt.setString(6,email);
                stmt.execute();
                stmt.close();
            }
            catch(SQLException exception){
                Notification.show("Cannot Enroll Pharmacy");
            }
        }
    }
}
