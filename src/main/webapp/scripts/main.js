(function() {

  $(document).on('click', '[data-action="update-alternative"]', openEditModalWindow);
  $(document).on('click', '[data-action="update-user"]', openEditModalWindowUser);

  function openEditModalWindow(e) {
    const target = $(e.target);
    const alternativeId = target.data('id');
    const row = target.parents('li');
    const alternativeName = row.find('.alternative-name').text();
    const form = $('.modal').find('form');
    const nameField = form.find('#alternative-name');
    const idField = form.find('#alternative-id');

    form.attr('action', '/alternatives/update');
    nameField.val(alternativeName);
    idField.val(alternativeId);
  }

  function openEditModalWindowUser(e) {
    const target = $(e.target);
    const userId = target.data('id');
    const row = target.parents('li');
    const role = row.data('role');
    const userName = row.find('.user-name').text();
    const form = $('.user-form');
    const nameField = form.find('#user-name');
    const idField = form.find('#user-id');
    const roleField = form.find('#role');

    form.attr('action', '/users/update');
    nameField.val(userName);
    idField.val(userId);
    roleField.find('option').toArray().forEach(elem => {
      elem = $(elem);
      if(elem.text() == role) {
        elem.attr('selected', true);
      }
    });
  }

}());