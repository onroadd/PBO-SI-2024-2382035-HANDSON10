package views;
import entities.TodoList;
import java.util.Scanner;
import services.TodoListService;
public class TodoListTerminalViewImpl implements TodoListView {
    public static Scanner scanner = new Scanner(System.in);
    private final TodoListService todoListService;
    public TodoListTerminalViewImpl(TodoListService todoListService) {
        this.todoListService = todoListService;
    }
    public String input(String info) {
        System.out.print(info + " : ");
        var data = scanner.nextLine();
        return data;
    }
    public void showMainMenu() {
        // infinite loop so the program will always run
        boolean isRunning = true;
        while (isRunning) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Edit");
            System.out.println("4. Keluar");
            // input untuk menerima input dari user
            String selectedMenu = input("Pilih");
            switch (selectedMenu) {
                case "1":
                    showMenuAddTodoList();
                    break;
                case "2":
                    showMenuRemoveTodoList();
                    break;
                case "3":
                    showMenuEditTodoList();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
    public void showMenuRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");
        var number = input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")) {
            //batal
        } else {
            boolean success = todoListService.removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todo list : " + number);
            }
        }
    }
    public void showMenuAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");
        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            // batal
        } else {
            todoListService.addTodoList(todo);
        }
    }
    public void showMenuEditTodoList() {
        System.out.println("MENGEDIT TODO LIST");
        String selectedTodo = input("Masukkan nomor todo (x jika batal)");
        if (selectedTodo.equals("x")) {
            return;
        }
        String newTodo = input("Masukkan todo yang baru (x jika batal)");
        if (newTodo.equals("x")) {
            return;
        }
        boolean isEditTodoSuccess = todoListService.editTodoList(Integer.valueOf(selectedTodo), newTodo);
        if (isEditTodoSuccess) {
            System.out.println("Berhasil mengedit todo");
        } else {
            System.out.println("Gagal mengedit todo");
        }
    }
    public void showTodoList() {
        System.out.println("TODO LIST");
        TodoList[] todoList = todoListService.getTodoList();
        for (var i = 0; i < todoList.length; i++) {
            var todo = todoList[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo.getTodo());
            }
        }
    }
    @Override
    public void run() {
        showMainMenu();
    }
}
‎views/TodoListView.java
+5
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,5 @@
        package views;
public interface TodoListView {
    void run();
}
