$(document).ready(function () {
    $(function () {
        $("#inputSearch").autocomplete({
            source: function (request, response) {
                $.ajax({
                    url: "/getBrands",
                    type: "GET",
                    data: {term: request.term},

                    dataType: "json",

                    success: function (data) {
                        response($.map(data, function (v, i) {
                            return {
                                label: v.name,
                                value: v.name

                            };
                        }));
                    }
                });
            }
        });
    });
});