jQuery(document).ready(function() {

	container = $('.container');
	cover = $('.cover');
	play = $('#play');
	pause = $('#pause');
	mute = $('#mute');
	muted = $('#muted');
	close = $('#close');
	currentSongId = 1;
	song = new Audio("music/track"+currentSongId+"mp3");
	duration = song.duration;
    song.type= 'audio/mpeg';
    song.src= 'music/track'+currentSongId+'.mp3';
    next = $('#next');
    prev = $('#prev');

	play.click(function(e) {
		e.preventDefault();
		song.play();

		//$(this).replaceWith('<a class="button gradient" id="pause" href="" title=""></a>');
		container.addClass('containerLarge');
		cover.addClass('coverLarge');
		$('#close').fadeIn(300);
		$('#seek').attr('max',song.duration);
	});

	pause.click(function(e) {
		e.preventDefault();
		song.pause();
		//$(this).replaceWith('<a class="button gradient" id="play" href="" title=""></a>');

	});

	mute.click(function(e) {
		e.preventDefault();
		song.volume = 0;
		$(this).replaceWith('<a class="button gradient" id="muted" href="" title=""></a>');

	});

	muted.click(function(e) {
		e.preventDefault();
		song.volume = 1;
		$(this).replaceWith('<a class="button gradient" id="mute" href="" title=""></a>');

	});

	next.click(function (e){
		suivante(e);
	});

	prev.click(function(e){
		prevsongId= currentSongId-1;
		e.preventDefault();
		song.src='music/track'+prevsongId+".mp3";		
		currentSongId = prevsongId;	
		song.play();
	});

	$('#close').click(function(e) {
		e.preventDefault();
		container.removeClass('containerLarge');
		cover.removeClass('coverLarge');
		song.pause();
		song.currentTime = 0;
		$('#pause').replaceWith('<a class="button gradient" id="play" href="" title=""></a>');
		$('#close').fadeOut(300);
	});



	$("#seek").bind("change", function() {
		song.currentTime = $(this).val();
		$("#seek").attr("max", song.duration);

	});

	song.addEventListener('timeupdate',function (e){
		curtime = parseInt(song.currentTime, 10);
		$("#seek").val(curtime);
		if (song.ended){
		suivante(e);
		}
	});
	
	
});
function suivante(e) {
		e.preventDefault();
		nextsongId= currentSongId+1;
		song.src='music/track'+nextsongId+".mp3";
		currentSongId = nextsongId;		
		song.play();
		$("#seek").val(0);


	}
