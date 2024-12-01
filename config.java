public Connection getConnection() {
    if (connection == null) {
        throw new IllegalStateException("Database connection is not established.");
    }
    return connection;
}
package entities;

public class TodoList {
    private int id;
    private String todo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
