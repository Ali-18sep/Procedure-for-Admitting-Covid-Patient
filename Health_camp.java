import java.util.ArrayList;
import java.util.Scanner;

public class Health_camp {

	public static int Total_no_of_notAdmitted_patient;
	public static int admitted_patient=0;
	public static int p_ID=1;
	private static Patient p;
	public static ArrayList<Patient> arr;
	private static int number;
	public static Institute institute;

	public Health_camp(){
		this.takeInput();
	}

	private void takeInput() {
		arr = new ArrayList<Patient>();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		number = n;
		for(int i=0; i<n; i++) {
			String name = sc.next();
			Total_no_of_notAdmitted_patient++;
			float body_tem = sc.nextFloat();
			int oxl = sc.nextInt();
			int age = sc.nextInt();
			p = new Patient();
			p.setAge(age);
			p.setBody_temp(body_tem);
			p.setName(name);
			p.setOxygen_level(oxl);
			p.setpatient_ID(p_ID);
			//p.info = arr;
			p_ID++;
			arr.add(p);
		}

	}



	public static void main(String[] args) {

		System.out.println("Sample Case:");

		Health_camp h = new Health_camp();



		while(admitted_patient!=number) {
			Scanner sc = new Scanner(System.in);


			int s = sc.nextInt();

			if(s==1) {
				institute = new Institute(arr);
				institute.input();
			}
			if(s==9) {
				System.out.println("Enter Institute name to get the name of patient admitted and their recovery time");
				String inst_name = sc.next();
				Patient p1 = new Patient();
				p1.Display(inst_name);
			}
			if(s==8) {
				Patient.displayAll_patients_name_ID();
			}
			if(s==7) {
				int id = sc.nextInt();
				Patient.display_particular_patient(id);
			}
			if(s==6) {
				String str = sc.next();
				Institute.details_Of_healthcare_inst(str);
			}
			if(s==5) {
				System.out.println(Institute.no_of_OpenedInst+" "+"institutes are admitting patients currently");
			}
			if(s==4) {
				System.out.println(Total_no_of_notAdmitted_patient+" "+"Patients");
			}
			if(s==3) {
				Institute.apllication_Closed();
			}
			if(s==2) {
				Patient.display_removedAccountof_admittedPatient();
			}
		}
	}



}

class Patient{

	private String name;
	private int age;
	private int Oxygen_level;
	private float body_temp;
	private int patient_ID;
	private int no_of_recovery_days;
	private String Admission_status = "Not admitted";
	private String Name_of_healthcare_Institue;
	private boolean visited;
	public static ArrayList<Patient> info = Health_camp.arr;

	public boolean delete_account=false;
	
	public boolean getVisited() {
		return visited;
	}
	public void setVisited(Boolean visited) {
		this.visited = visited;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getOxygen_level() {
		return Oxygen_level;
	}

	public void setOxygen_level(int oxygen_level) {
		Oxygen_level = oxygen_level;
	}

	public float getBody_temp() {
		return body_temp;
	}

	public void setBody_temp(float body_temp) {
		this.body_temp = body_temp;
	}

	public void setpatient_ID(int patient_ID) {
		this.patient_ID = patient_ID;
	}
	public int getpatient_ID() {
		return patient_ID;
	}

	public void setRecoveryDays(int recovery_days) {
		this.no_of_recovery_days = recovery_days;
	}

	public int getRecoveryDays() {
		return no_of_recovery_days;
	}

	public void setAdmission_status(String s) {
		this.Admission_status = s;
	}

	public String getAdmission_status() {
		return Admission_status;
	}

	public void setInstituteName(String s2) {
		this.Name_of_healthcare_Institue = s2;
	}

	public String getInstituteName() {
		return Name_of_healthcare_Institue;
	}


	public void Display(String inst_name) { // Display names of patients admitted in an Institute and their recovery time!

		for(int i=0; i<info.size(); i++) {
			//System.out.println("size"+info.size());
			int help = i+1;
			if(info.get(i).Admission_status.equals("Admitted") && info.get(i).Name_of_healthcare_Institue.equals(inst_name)) {
				System.out.println(info.get(i).name+","+"recovery time is"+" "+info.get(i).no_of_recovery_days+" "+"days");
			}
		}

		//for(int i=0;i<info.size(); i++) {
		//if(info.get(i).Name_of_healthcare_Institue!=null) {
		//System.out.println(info.get(i).Name_of_healthcare_Institue);
		//}
		//}

	}

	public static void displayAll_patients_name_ID() { //Display all the patient names and ID’s generated !

		for(int i=0; i<info.size();i++) {
			if(info.get(i).delete_account==false) {
				System.out.println(info.get(i).patient_ID+" "+info.get(i).name);
			}
		}

	}

	public static void display_particular_patient(int id) { //Display details of particular patient !

		for(int i=0; i<info.size(); i++) {
			if(info.get(i).delete_account==false && info.get(i).patient_ID==id) {
				//System.out.println("ID_Number:"+" "+info.get(i).patient_ID);
				System.out.println(info.get(i).name);
				System.out.println("Temperature is"+" "+info.get(i).body_temp);
				System.out.println("Oxygen level is:"+" "+info.get(i).Oxygen_level);
				System.out.println("Admisson Status - "+" "+info.get(i).Admission_status);
				System.out.println("Admitting institute - "+" "+info.get(i).Name_of_healthcare_Institue );
			}
		}

	}

	public static void display_removedAccountof_admittedPatient() {//Remove the accounts of admitted patients
		System.out.println("Account ID removed of admitted patients:");
		for(int j=0;j<info.size();j++) {
			if(info.get(j).Admission_status.equals("Admitted")) {
				System.out.println(info.get(j).patient_ID);
				info.get(j).delete_account=true;;
				//info.add(j,p);
			}


		}

	}

	public static void print() {
		for(int i=0; i<info.size(); i++) {
			System.out.println(info.get(i).name+" "+info.get(i).getBody_temp()
					+" "+info.get(i).getOxygen_level()+" "+info.get(i).getpatient_ID()+" "+info.get(i).getAge());
		}
	}
}


class Institute{
	private String name;
	private String status="CLOSED";
	public static int no_of_OpenedInst=0;
	private int no_of_available_beds;
	private int Oxygen_criteria;
	private float temp_criteria;
	private int no_of_admitted_patients;
	private ArrayList<Patient> patient_data;
	//private String Application_closed="OPEN";
	private static ArrayList<Institute> inst = new ArrayList<Institute>();

	private boolean delete_inst=false;


	public Institute(ArrayList<Patient> patient) {
		this.patient_data = patient;
	}

	public void input() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the Health_Care_Institute:");
		this.name = sc.next();
		System.out.println("Eneter temperature criteria");
		this.temp_criteria = sc.nextFloat();
		System.out.println("Enter Oxygen Criteria");
		this.Oxygen_criteria = sc.nextInt();
		System.out.println("Enter number of beds");
		this.no_of_available_beds = sc.nextInt();
		this.no_of_OpenedInst++;
		this.status = "OPEN";
		this.print();

		int i;

		for(i=0; i<patient_data.size();i++) {
			if(this.no_of_available_beds!=0 && patient_data.get(i).getOxygen_level()>=this.Oxygen_criteria && !patient_data.get(i).getAdmission_status().equals("Admitted")){
				patient_data.get(i).setAdmission_status("Admitted");
				patient_data.get(i).setInstituteName(this.name);
				no_of_available_beds-=1;
				no_of_admitted_patients+=1;
				Health_camp.admitted_patient++;
				Health_camp.Total_no_of_notAdmitted_patient-=1;
			}
		}

		if(this.no_of_available_beds>0) {
			//System.out.println("no of available beds"+" "+this.no_of_available_beds);
			for(int k=0; k<patient_data.size(); k++) {
				if(this.no_of_available_beds!=0 && patient_data.get(k).getBody_temp()<=this.temp_criteria && !patient_data.get(k).getAdmission_status().equals("Admitted")){
					i++;
					patient_data.get(k).setInstituteName(this.name);
					patient_data.get(k).setAdmission_status("Admitted");
					this.no_of_available_beds-=1;
					no_of_admitted_patients+=1;
					Health_camp.admitted_patient++;
				}
				else {
					i++;
				}
			}
		}
		if(this.no_of_available_beds==0) {
			this.status = "CLOSED";
			this.no_of_OpenedInst--;
		}

		int k=0;
		int pointer = no_of_admitted_patients;
		while(pointer>0) {
			//System.out.println("Pointer:" + " "+pointer);
			if(patient_data.get(k).getAdmission_status().equals("Admitted") && patient_data.get(k).getVisited()==false) {
				System.out.println("Enter recovery days for admitted patient ID"+" "+patient_data.get(k).getpatient_ID());
				int recovery_days = sc.nextInt();
				patient_data.get(k).setRecoveryDays(recovery_days);
				patient_data.get(k).setVisited(true);
				k++;
				pointer-=1;
			}
			else {
				k++;
			}
		}
		inst.add(this);
	}

	private void print() {

		System.out.println(this.name);

		System.out.println("Temperature should be <="+" "+this.temp_criteria);
		System.out.println("Oxygen levels should be >="+" "+this.Oxygen_criteria);
		System.out.println("Number of Available beds -"+" "+this.no_of_available_beds);
		System.out.println("Admission status -"+" "+this.status);
	}


	public static void details_Of_healthcare_inst(String str) { //Display details of the Health Care Institute !
		for(int i=0; i<inst.size(); i++) {
			if(inst.get(i).delete_inst==false && inst.get(i).name.equals(str)) {
				System.out.println(inst.get(i).name);
				System.out.println("Temperature should be <="+" "+inst.get(i).temp_criteria);
				System.out.println("Oxygen_level should be >="+" "+inst.get(i).Oxygen_criteria);
				System.out.println("Number of Available beds -"+" "+inst.get(i).no_of_available_beds);
				System.out.println("Admission Status -"+" "+inst.get(i).status);
			}
		}
	}

	public static void apllication_Closed() { // Remove the accounts of health care 
		//institutes whose applications are closed
		System.out.println("Accounts removed of Institute whose admission is closed:");
		for(int i=0; i<inst.size();i++) {
			if(inst.get(i).no_of_available_beds==0) {
				System.out.println(inst.get(i).name);
				inst.get(i).delete_inst = true;
				//inst.add(i,null);
			}
		}
	}

}
