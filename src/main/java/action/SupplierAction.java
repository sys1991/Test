package action;

import model.Supplier;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/13.
 *
 */
@WebServlet(urlPatterns = "/Supplier")
public class SupplierAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            add(req, resp);
        }
        if (action.equals("queryAll")) {
            queryAll(req, resp);
        }
        if (action.equals("remove")) {
            remove(req, resp);
        }
        if (action.equals("update")) {
            update(req, resp);
        }
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String people = req.getParameter("people");
        String goods = req.getParameter("goods");
        int tel =Integer.parseInt(req.getParameter("tel"));

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection == null) {
            return;
        }

        String sql = "INSERT INTO forth.supplier VALUES (NULL,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, people);
            preparedStatement.setString(4, goods);
            preparedStatement.setInt(5, tel);

            preparedStatement.executeUpdate();


            resp.sendRedirect("/Supplier?action=queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement, connection);
        }


    }

    protected void queryAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "SELECT * FROM forth.supplier;";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            List<Supplier> suppliers = new ArrayList<>();
            while (resultSet.next()) {
                Supplier supplier = new Supplier(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("people"), resultSet.getString("goods"), resultSet.getString("tel"));
                suppliers.add(supplier);
            }
            req.getSession().setAttribute("suppliers",suppliers);
            resp.sendRedirect("/suppliers.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement,connection);
        }

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String people = req.getParameter("people");
        String goods = req.getParameter("goods");
        String tel = req.getParameter("tel");

        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE forth.supplier SET name = ?, address = ?, people = ?, goods = ?,tel = ? WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, people);
            preparedStatement.setString(4, goods);
            preparedStatement.setString(5,tel);
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();

            resp.sendRedirect("/Supplier?action=queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement, connection);
        }
    }



    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Connection connection = DB.getConnection();
        if (connection == null) {
            return;
        }
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM forth.supplier WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            resp.sendRedirect("/Supplier?action=queryAll");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.close(null, preparedStatement, connection);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
