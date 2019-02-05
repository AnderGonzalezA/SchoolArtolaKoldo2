import com.zubiri.school.*;
import java.util.Scanner;
import java.util.Calendar;

public class Interface {

	public static void main(String[] args) {
		School school = new School("Zubiri");
		Student student = new Student();
		Teacher teacher = new Teacher();
		Administrative admin = new Administrative();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Welcome to our school database, select one of these three");
			System.out.println("1.- Students");
			System.out.println("2.- Teachers");
			System.out.println("3.- Administratives");
			System.out.println("4.- Change the school name");
			System.out.println("0.- Quit");
			if (sc.hasNextInt()) {
				switch (sc.nextInt()) {
				default:
					System.out.println("Please, enter a valid option");
					break;

				case 1:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add student");
					System.out.println("2.- Delete student");
					System.out.println("3.- Get the age of a student");
					System.out.println("4.- Check absenses of a student");
					System.out.println("5.- Order alphabetically all the students by name");
					System.out.println("6.- Get the students of a teacher");
					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						default:
							System.out.println("Please, enter a valid option");
							break;

						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							System.out.println("year:");
							int year = sc.nextInt();
							System.out.println("month:");
							int month = sc.nextInt();
							System.out.println("day:");
							int day = sc.nextInt();
							Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601")
									.setDate(year, month, day).build();
							if (!student.checkDate(birthDate)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!student.checkPhoneNumber(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!student.checkDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}
							System.out.println("Absenses");
							int absenses = sc.nextInt();
							System.out.println("Mark average");
							int average = sc.nextInt();
							System.out.println("Classroom");
							String classroom = sc.next();
							System.out.println("Course");
							int course = sc.nextInt();
							System.out.println("Repeater (y/n)");
							String repeater = sc.next();
							boolean repeater2;
							if (repeater.equals("y")) {
								repeater2 = true;
							} else if (repeater.equals("n")) {
								repeater2 = false;
							} else {
								System.out.println("Incorrect option");
								break;
							}

							Student newstudent = new Student();
							newstudent.setAbsenses(absenses);
							newstudent.setBirthDate(birthDate);
							newstudent.setClassroom(classroom);
							newstudent.setCourse(course);
							newstudent.setDni(dni);
							newstudent.setMarkAverage(average);
							newstudent.setName(name);
							newstudent.setPhoneNumber(telephone);
							newstudent.setRepeater(repeater2);
							school.generateID(newstudent);

							school.addStudent(newstudent);
							System.out.println("Succesfuly added");

							break;

						case 2:
							System.out.println("ID of the student");
							sc.nextLine();
							name = sc.nextLine();

							if (school.findStudent(name) != -1) {
								school.deleteStudent(school.findStudent(name));
								if (school.findStudent(name) != -1) {
									System.out.println("Student removed");
								} else {
									System.out.println("An error occurred");
								}

							} else {
								System.out.println("Student not found");
							}

							break;

						case 3:
							System.out.println("ID of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudent(name) != -1)
								System.out.println(school.getStudent(school.findStudent(name)).age());
							else
								System.out.println("Student not found");
							break;

						case 4:
							System.out.println("Name of the student");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findStudent(name) != -1)
								System.out.println(school.getStudent(school.findStudent(name)).getAbsenses());
							else
								System.out.println("Student not found");
							break;

						case 5:
							school.orderStudents();
							break;
						case 6:
							System.out.println("ID of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println(school.getStudentsByTeacherID(name));
							break;
						}

					} else {
						System.out.println("Please, enter a valid option");
					}
					break;

				case 2:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add a teacher");
					System.out.println("2.- Delete a teacher");
					System.out.println("3.- Get the age of a teacher");
					System.out.println("4.- Check if he/she is tutor");
					System.out.println("5.- Add a subject");
					System.out.println("6.- Delete a subject");
					System.out.println("7.- Order teachers");
					System.out.println("8.- Print teachers");
					System.out.println("9.- Get the teacher of a subject");

					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						default:
							System.out.println("Please, enter a valid option");
							break;

						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							System.out.println("year:");
							int year = sc.nextInt();
							System.out.println("month:");
							int month = sc.nextInt();
							System.out.println("day:");
							int day = sc.nextInt();
							Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601")
									.setDate(year, month, day).build();
							if (!student.checkDate(birthDate)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!student.checkPhoneNumber(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!student.checkDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}

							System.out.println("Salary");
							double salary = sc.nextDouble();
							System.out.println("Joined date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							Calendar joined = new Calendar.Builder().setCalendarType("iso8601")
									.setDate(year, month, day).build();
							if (!student.checkDate(birthDate)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Tutor(write 'no' if not)");
							String tutor = sc.next();

							Teacher newTeacher = new Teacher();
							newTeacher.setBirthDate(birthDate);
							newTeacher.setDni(dni);
							newTeacher.setJoined(joined);
							newTeacher.setName(name);
							newTeacher.setPhoneNumber(telephone);
							newTeacher.setTutor(tutor);
							newTeacher.setSalary(salary);
							school.generateID(newTeacher);

							school.addTeacher(newTeacher);
							System.out.println("Succesfully added");

							break;

						case 2:
							System.out.println("ID of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacher(name) != -1) {
								school.deleteTeacher(school.findTeacher(name));
								if (school.findTeacher(name) == -1) {
									System.out.println("Teacher removed");
								} else {
									System.out.println("An error ocurred");
								}
							} else {
								System.out.println("Teacher not found");
							}

							break;

						case 3:
							System.out.println("ID of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacher(name) != -1)
								System.out.println(school.getTeacher(school.findTeacher(name)).age());
							else
								System.out.println("Teacher not found");
							break;

						case 4:
							System.out.println("ID of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findTeacher(name) != -1)
								System.out.println(school.getTeacher(school.findTeacher(name)).isTutor());
							else
								System.out.println("Teacher not found");

							break;

						case 5:
							System.out.println("ID of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							String subject = sc.next();

							if (school.findTeacher(name) != -1) {
								if (school.getTeacher(school.findTeacher(name)).findSubject(subject) == -1) {
									school.getTeacher(school.findTeacher(name)).addSubject(subject);
									if (school.getTeacher(school.findTeacher(name)).findSubject(subject) != -1) {
										System.out.println("Subject added");
									} else {
										System.out.println("An error occurred");
									}

								} else {
									System.out.println("Subject already added");
								}
							} else {
								System.out.println("Teacher not found");
							}
							break;

						case 6:
							System.out.println("Name of the teacher");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the subject");
							subject = sc.next();
							if (school.findTeacher(name) != -1) {
								if (school.getTeacher(school.findTeacher(name)).findSubject(subject) != -1) {
									school.getTeacher(school.findTeacher(name)).deleteSubject(
											school.getTeacher(school.findTeacher(name)).findSubject(subject));
									if (school.getTeacher(school.findTeacher(name)).findSubject(subject) == -1) {
										System.out.println("Subject deleted");
									} else {
										System.out.println("An error occurred");
									}

								} else {
									System.out.println("Subject not found");
								}
							} else {
								System.out.println("Teacher not found");
							}
							break;
						case 7:
							school.orderTeachers();
							break;
						case 8:
							school.printTeachers();
							break;
						case 9:
							System.out.println("Name of the subject");
							sc.nextLine();
							subject = sc.next();
							System.out.println(school.findTeacherIDBySubject(subject));
							
							break;
						}

					}
					break;

				case 3:
					System.out.println("What do you want to do?");
					System.out.println("1.- Add an administrative");
					System.out.println("2.- Delete an administrative");
					System.out.println("3.- Check absenses");
					System.out.println("4.- Add a language");

					if (sc.hasNextInt()) {
						switch (sc.nextInt()) {
						case 1:
							System.out.println("Name");
							sc.nextLine();
							String name = sc.nextLine();
							System.out.println("Birth Date");
							System.out.println("year:");
							int year = sc.nextInt();
							System.out.println("month:");
							int month = sc.nextInt();
							System.out.println("day:");
							int day = sc.nextInt();
							Calendar birthDate = new Calendar.Builder().setCalendarType("iso8601")
									.setDate(year, month, day).build();
							if (!student.checkDate(birthDate)) {
								System.out.println("Incorrect date");
								break;
							}
							System.out.println("Telephone");
							String telephone = sc.next();
							if (!student.checkPhoneNumber(telephone)) {
								System.out.println("Incorrect telephone");
								break;
							}
							System.out.println("DNI");
							String dni = sc.next();
							if (!student.checkDni(dni)) {
								System.out.println("Incorrect DNI");
								break;
							}

							System.out.println("Salary");
							double salary = sc.nextDouble();
							System.out.println("Joined date");
							System.out.println("year:");
							year = sc.nextInt();
							System.out.println("month:");
							month = sc.nextInt();
							System.out.println("day:");
							day = sc.nextInt();
							Calendar joined = new Calendar.Builder().setCalendarType("iso8601")
									.setDate(year, month, day).build();
							if (!student.checkDate(birthDate)) {
								System.out.println("Incorrect date");
								break;
							}

							Administrative newAdmin = new Administrative();
							newAdmin.setBirthDate(birthDate);
							newAdmin.setDni(dni);
							newAdmin.setJoined(joined);
							newAdmin.setName(name);
							newAdmin.setPhoneNumber(telephone);
							newAdmin.setSalary(salary);

							school.addAdministrative(newAdmin);
							System.out.println("Succesfully added");

							break;

						case 2:
							System.out.println("ID of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findAdministrative(name) != -1) {
								school.deleteTeacher(school.findAdministrative(name));
								if (school.findAdministrative(name) == -1) {
									System.out.println("Administrative removed");
								} else {
									System.out.println("An error ocurred");
								}
							} else {
								System.out.println("Administrative not found");
							}
							break;

						case 3:
							System.out.println("ID of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							if (school.findAdministrative(name) != -1)
								System.out.println(school.getAdministrative(school.findAdministrative(name)).age());
							else
								System.out.println("Administrative not found");
							break;

						case 4:
							System.out.println("ID of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the language");
							String language = sc.next();
							if (school.findAdministrative(name) != -1) {
								school.getAdministrative(school.findAdministrative(name)).addLanguages(language);
								System.out.println("Language added");
							}

							else {
								System.out.println("Administrative not found");
							}
							break;

						case 5:
							System.out.println("ID of the administrative");
							sc.nextLine();
							name = sc.nextLine();
							System.out.println("Name of the language");
							language = sc.next();
							if (school.findAdministrative(name) != -1) {
								if (school.getAdministrative(school.findAdministrative(name))
										.findLanguage(language) != -1) {
									school.getAdministrative(school.findAdministrative(name)).removeLanguage(school
											.getAdministrative(school.findAdministrative(name)).findLanguage(language));
									school.getAdministrative(school.findAdministrative(name)).findLanguage(language);
									if (school.getAdministrative(school.findAdministrative(name))
											.findLanguage(language) == -1) {
										System.out.println("Subject deleted");
									} else {
										System.out.println("An error occurred");
									}

								} else {
									System.out.println("Subject not found");
								}
							} else {
								System.out.println("Teacher not found");
							}
							break;

						}
					}

					break;
				case 4:
					System.out.println("Please, enter the new school name.");
					school.setSchooolName(sc.nextLine());

				case 0:
					flag = false;
					System.out.println("Bye!");
					break;

				}
			} else {
				System.out.println("Please, enter a valid option");
			}
		}
	}

}