package com.learners.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.learners.dao.ClassesDao;
import com.learners.dao.StudentDao;
import com.learners.dao.SubjectDao;
import com.learners.dao.TeacherDao;
import com.learners.model.Classes;
import com.learners.model.Student;
import com.learners.model.Subject;
import com.learners.model.Teacher;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherDao teacherDAO;
	private StudentDao studentDAO;
	private ClassesDao classesDAO;
	private SubjectDao subjectDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherServlet() {
		this.teacherDAO = new TeacherDao();
		this.studentDAO = new StudentDao();
		this.classesDAO = new ClassesDao();
		this.subjectDAO = new SubjectDao();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/newTeacher":
			showNewForm(request, response);
			break;
		case "/insertTeacher":
			insertTeacher(request, response);
			break;
		case "/deleteTeacher":
			deleteTeacher(request, response);
			break;
		case "/editTeacher":
			showEditForm(request, response);
			break;
		case "/updateTeacher":
			updateTeacher(request, response);
			break;
		case "/listTeacher":
			listTeacher(request, response);
			break;
		case "/newStudent":
			showNewStudentForm(request, response);
			break;
		case "/insertStudent":
			insertStudent(request, response);
			break;
		case "/deleteStudent":
			deleteStudent(request, response);
			break;
		case "/editStudent":
			showStudentEditForm(request, response);
			break;
		case "/updateStudent":
			updateStudent(request, response);
			break;
		case "/listStudent":
			listStudent(request, response);
			break;
		case "/newClasses":
			showNewClassForm(request, response);
			break;
		case "/insertClasses":
			insertClasses(request, response);
			break;
		case "/listClasses":
			listClasses(request, response);
			break;
		case "/newSubject":
			showNewSubjectForm(request, response);
			break;
		case "/insertSubject":
			insertSubject(request, response);
			break;
		case "/deleteSubject":
			deleteSubject(request, response);
			break;
		case "/editSubject":
			showEditSubjectForm(request, response);
			break;
		case "/updateSubject":
			updateSubject(request, response);
			break;
		case "/listSubject":
			listSubject(request, response);
			break;
		default:
			defaultLogin(request, response);
			break;
		}
	}

	private void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> listSubject = null;
		try {
			listSubject=subjectDAO.selectAllSubjects();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("listSubject", listSubject);
		System.out.println(listSubject + " " + "List Subject method in servlet\n");
		RequestDispatcher rd = request.getRequestDispatcher("subject-list.jsp");
		System.out.println("forward to subject-list.jsp");
		rd.forward(request, response);
		System.out.println("Forwarded to subject-list.jsp");
	}

	private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int subject_id = Integer.parseInt(request.getParameter("subject_id"));
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		String subject_name = request.getParameter("subject_name");

		System.out.println(subject_id + teacher_id + subject_name);
		Subject subject = new Subject(subject_id, teacher_id, subject_name);
		try {
			subjectDAO.updateSubject(subject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listSubject");
	}

	private void showEditSubjectForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Called showEditSubjectForm");
		String data = request.getParameter("subject_id");
		System.out.println(data);
		int subject_id = Integer.parseInt(request.getParameter("subject_id"));
		System.out.println(subject_id + "Calling edit subject form from servlet");
		try {
			Subject existingSubject = subjectDAO.selectSubject(subject_id);
			RequestDispatcher rd = request.getRequestDispatcher("subject-form.jsp");
			request.setAttribute("subject", existingSubject);

			System.out.println(existingSubject);
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int subject_id = Integer.parseInt(request.getParameter("subject_id"));
		try {
			subjectDAO.deleteSubject(subject_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(subject_id);
		response.sendRedirect("listSubject");

	}

	private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		String subject_name = request.getParameter("subject_name");

		System.out.println(teacher_id + subject_name);
		Subject newSubject = new Subject(teacher_id, subject_name);
		try {
			subjectDAO.insertSubject(newSubject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listSubject");
	}

	private void showNewSubjectForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("subject-form.jsp");
		System.out.println("Forwarded to subject-form.jsp");
		rd.forward(request, response);

	}

	private void listClasses(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Classes> listClasses = null;
		try {
			listClasses = classesDAO.selectAllClasses();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listClasses", listClasses);
		System.out.println(listClasses + " " + "List Student method in servlet\n");
		RequestDispatcher rd = request.getRequestDispatcher("classes-list.jsp");
		System.out.println("forward to classes-list.jsp");
		rd.forward(request, response);
		System.out.println("Forwarded to classes-list.jsp");
	}

	private void insertClasses(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String class_name = request.getParameter("class_name");

		System.out.println(class_name);
		Classes newClasses = new Classes(class_name);
		try {
			classesDAO.insertClass(newClasses);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listClasses");

	}

	private void showNewClassForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("classes-form.jsp");
		System.out.println("Forwarded to classes-form.jsp");
		rd.forward(request, response);

	}

	private void defaultLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
		System.out.println("Forwarded to Login-success.jsp");
		rd.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("teacher-form.jsp");
		System.out.println("Forwarded to teacher-form.jsp");
		rd.forward(request, response);
	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teacher_name = request.getParameter("teacher_name");
		String teacher_email = request.getParameter("teacher_email");
		int teacher_class = Integer.parseInt(request.getParameter("teacher_class"));

		System.out.println(teacher_name + teacher_email + teacher_class);
		Teacher newTeacher = new Teacher(teacher_name, teacher_email, teacher_class);
		try {
			teacherDAO.insertTeacher(newTeacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listTeacher");
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		try {
			teacherDAO.deleteTeacher(teacher_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(teacher_id);
		response.sendRedirect("listTeacher");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Called showEditForm");
		String data = request.getParameter("teacher_id");
		System.out.println(data);
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		System.out.println(teacher_id + "Calling edit form from servlet");
		try {
			Teacher exestingTeacher = teacherDAO.selectTeacher(teacher_id);
			RequestDispatcher rd = request.getRequestDispatcher("teacher-form.jsp");
			request.setAttribute("teacher", exestingTeacher);

			System.out.println(exestingTeacher);
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		String teacher_name = request.getParameter("teacher_name");
		String teacher_email = request.getParameter("teacher_email");
		int teacher_class = Integer.parseInt(request.getParameter("teacher_class"));

		System.out.println(teacher_id + teacher_name + teacher_email + teacher_class);

		Teacher teacher = new Teacher(teacher_id, teacher_name, teacher_email, teacher_class);
		try {
			teacherDAO.updateTeacher(teacher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listTeacher");

	}

	private void listTeacher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Teacher> listTeacher = null;
		try {
			listTeacher = teacherDAO.selectAllTeachers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listTeacher", listTeacher);
		System.out.println(listTeacher + " " + "List Teacher method in servlet\n");
		RequestDispatcher rd = request.getRequestDispatcher("teacher-list.jsp");
		System.out.println("forward to teacher-list.jsp");
		rd.forward(request, response);
		System.out.println("Forwarded to teacher-list.jsp");
	}

	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("student-form.jsp");
		System.out.println("Forwarded to student-form.jsp");
		rd.forward(request, response);
	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String student_name = request.getParameter("student_name");
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		String student_address = request.getParameter("student_address");
		String student_mobile = request.getParameter("student_mobile");

		System.out.println(student_name + class_id + student_address + student_mobile);
		Student newStudent = new Student(student_name, class_id, student_address, student_mobile);
		try {
			studentDAO.insertStudent(newStudent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("listStudent");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		try {
			studentDAO.deleteStudent(student_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(student_id);
		response.sendRedirect("listStudent");
	}

	private void showStudentEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Called showStudentEditForm");
		String data = request.getParameter("student_id");
		System.out.println(data);
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		System.out.println(student_id + "-" + "Calling student edit form from servlet");
		try {
			Student exestingStudent = studentDAO.selectStudent(student_id);
			RequestDispatcher rd = request.getRequestDispatcher("student-form.jsp");
			request.setAttribute("student", exestingStudent);
			System.out.println(exestingStudent);
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entered into updateStudent method");
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		System.out.println(student_id);
		String student_name = request.getParameter("student_name");
		int class_id = Integer.parseInt(request.getParameter("class_id"));
		String student_address = request.getParameter("student_address");
		String student_mobile = request.getParameter("student_mobile");

		System.out.println(student_id + student_name + class_id + student_address + student_mobile);
		Student student = new Student(student_id, student_name, class_id, student_address, student_mobile);

		try {
			studentDAO.updateStudent(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listStudent");

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> listStudent = null;
		try {
			listStudent = studentDAO.selectAllStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("listStudent", listStudent);
		System.out.println(listStudent + " " + "List Student method in servlet\n");
		RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
		System.out.println("forward to student-list.jsp");
		rd.forward(request, response);
		System.out.println("Forwarded to student-list.jsp");
	}

}
