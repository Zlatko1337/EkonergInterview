jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});

document.addEventListener("DOMContentLoaded", function(event) {
	var scrollpos = sessionStorage.getItem('scrollpos');
	if (scrollpos) {
		window.scrollTo({ top: scrollpos, left: 0, behavior: "instant" })
		sessionStorage.removeItem('scrollpos');
	}
});

window.addEventListener("beforeunload", function(e) {
	sessionStorage.setItem('scrollpos', window.scrollY);
});