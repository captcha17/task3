function increaseCount(estateID) {
    $.post( "/countUp", { id: estateID })
        .done(function( data ) {
            $('#view'+estateID).text(data);
        });
};
