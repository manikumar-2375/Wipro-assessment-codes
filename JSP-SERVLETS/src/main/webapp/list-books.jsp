<table border="1">
<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
<c:forEach var="book" items="${bookList}">
<tr>
    <td>${book.id}</td>
    <td>${book.title}</td>
    <td>${book.author}</td>
    <td>${book.price}</td>
    <td>
        <a href="editBook?id=${book.id}">Edit</a>
        <a href="deleteBook?id=${book.id}">Delete</a>
    </td>
</tr>
</c:forEach>
</table>
