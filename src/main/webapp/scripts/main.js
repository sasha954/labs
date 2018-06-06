(function() {

  $(document).on('click', '[data-action="update"]', openEditModalWindow);

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

}());