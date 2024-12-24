package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GetTodoListLogic;
import model.PostTodoLogic;
import model.Todo;

@WebServlet("/Main2")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
		List<Todo> todoList = getTodoListLogic.execute();
		request.setAttribute("todoList", todoList);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力チェックnull確認
		if (text != null) {
			//セッションスコープに保存されたtodoを取得
			HttpSession session = request.getSession();
			Todo  todoList= (Todo) session.getAttribute("userContent");

			Todo todo = new Todo();
			PostTodoLogic postTodoLogic = new PostTodoLogic();
			postTodoLogic.execute(todo);
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "入力されていません");
		}

		//todo取得しリクエストスコープに保存
		GetTodoListLogic getTodoListLogic = new GetTodoListLogic();
		List<Todo> todoList = getTodoListLogic.execute();
		request.setAttribute("todoList", todoList);
		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
