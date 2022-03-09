var howmany = $( ".imagesbox .box_ppt_thumb" ).length;
function next1(){
        
        $( ".imagesbox .box_ppt_thumb:nth-child(1)" ).insertAfter('.imagesbox .box_ppt_thumb:nth-child('+ howmany+')');
      //  console.log(howmany);
    }
    function prev1(){
     
         $( '.box_ppt_thumb:nth-child('+ howmany+')' ).insertBefore('.box_ppt_thumb:nth-child(1)');
    }
window.setInterval(function(){
  next1();
}, 7000);

function getthesize(){
   
var divs = $('.containslide .box_ppt_thumb ');

var smallest;
var smallestarea = null;

$('.containslide .box_ppt_thumb ').each(function () {
  var thisarea = $(this).height();
  if (smallestarea === null || thisarea < smallestarea) {
    smallest = $(this);
    smallestarea = thisarea;
  }
});

  $('.containslide').css('height', smallest.css('height'));

}

$(window).on('load', function() {
  getthesize();
});


$( window ).resize(function() {
  getthesize();
});