$("#myModalEdit").on('show.bs.modal', function (e) {
    var userId = $(e.relatedTarget).data('user-id');

    var cols = $('#' + userId + ' td');
    var firstname = $(cols[1]).text();
    var id = $(cols[0]).text();
    var lastname = $(cols[2]).text();
    var email = $(cols[4]).text();
    var age = $(cols[3]).text();
    var roles = $(cols[5]).text();

    $('#firstNameInput').val(firstname); // Установите атрибут значения: firstname
    $('#lastNameInput').val(lastname);
    $('#emailInput').val(email);
    $('#idInput').val(id);
    $('#ageInput').val(age);
    $('#roleInput').val(roles);

});

$("#myModalDelete").on('show.bs.modal', function (e) {
    var user = $(e.relatedTarget).data('user-delete');

    var col = $('#' + user + ' td');
    var firstname = $(col[1]).text();
    var id = $(col[0]).text();
    var lastname = $(col[2]).text();
    var email = $(col[4]).text();
    var age = $(col[3]).text();
    var roles = $(col[5]).text();

    $('#firstName').val(firstname);
    $('#lastName').val(lastname);
    $('#email').val(email);
    $('#id').val(id);
    $('#age').val(age);


});

/*$("#myModalEdit").on('hidden.bs.modal', function () {
    var form = $(this).find('form');
    form[0].reset();
});*/

