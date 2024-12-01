public void showMenuRemoveTodoList() {
    System.out.println("MENGHAPUS TODO LIST");
    String number = input("Nomor yang dihapus (x jika batal)");
    if (!number.equals("x")) {
        try {
            int todoId = Integer.parseInt(number);
            boolean success = todoListService.removeTodoList(todoId);
            if (!success) {
                System.out.println("Gagal menghapus todo list dengan ID: " + todoId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Masukkan nomor yang valid.");
        }
    }
}
