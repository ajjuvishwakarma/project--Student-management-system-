import java.util.*;

 class Student //create a Student class and we can say it is parent class.
{
    int id;
    String name;
    float marks;
    Student(int id, String name, float marks)
    {
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    public void display()  //this method used to display students information.
    {
        System.out.print("\nID: "+id+"\nName: "+name+"\nMarks: "+marks);

    }
}
 class StudentManager  //create a StudentMaNager class and we can say it is child class.
{
  ArrayList<Student>students=new ArrayList<>(); // use of ArrayList<> and create object student.
  Scanner sc =new Scanner(System.in);//create object
  public void addStudent() // This method is create of add to students.
  {
    System.out.print("Enter ID: ");
    int id =sc.nextInt();
    sc.nextLine();//clear buffer
    System.out.println("Enter Name: ");
    String name=sc.nextLine();
    System.out.println("Enter Marks: ");
    float marks=sc.nextFloat();
    students.add(new Student(id,name,marks));
    System.out.println("Student added");
  }
  public void viewStudents() //This method is create of view of Students information.
  {
    if(students.isEmpty())
    {
        System.out.println("No students found.");
        return;
    }
    for(Student s:students)
    {
        s.display();
    }
  }
  public void updateStudent() //This method is create of  updates students  information.
  {
    System.out.println("Enter ID to update:");
    int id=sc.nextInt();
    for(Student s:students)
    {
        if(s.id==id)
        {
            sc.nextLine();
            System.out.print("Enter New Name:");
            s.name=sc.nextLine();
            System.out.print("Enter New Marks:");
            s.marks=sc.nextFloat();
            System.out.println("Student updated.");
            return;
        }
    }
    System.out.println("Student not found");
  }
  public void deleteStudent() //This methods create to delete student data 
  {
    System.out.println("Enter ID to delete: ");
    int id =sc.nextInt();
    Iterator<Student>itr=students.iterator();
    while(itr.hasNext())
    {
        Student s=itr.next();
        if(s.id==id)
        {
         itr.remove();
         System.out.println("Student deleted.");
         return;
        }
    }
    System.out.println("Student not found.");
  }
}

public class StudentManage  //this main class
{
 public static void main(String args[])
 {
    StudentManager manager=new StudentManager();//main method
    Scanner sc=new Scanner(System.in);
    int choice;
    do
    {
        System.out.println("\n---Student Record System---");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Eixt ");
        System.out.print("Enter choice:");
        choice=sc.nextInt();
        
        switch(choice) //switch statement of used to Enter choice  
        {
            case 1: manager.addStudent();
            break;
            case 2: manager.viewStudents();
            break;
            case 3: manager.updateStudent();
            break;
            case 4: manager.deleteStudent();
            case 5: System.out.println("Exiting! thanks for visit");
           default: System.out.println("Invalid choice."); 

    
        }
       
    }
     while(choice !=5);

 }
}