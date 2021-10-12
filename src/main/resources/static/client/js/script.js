/*---------------------toggle nav-------------------- */
const navToggler = document.querySelector(".nav-shift")
navToggler.addEventListener("click", toggleNav);

function toggleNav(e){
    navToggler.classList.toggle("active");
    document.querySelector(".navigation").classList.toggle("open")
}

/*-----------close nav when clicking on the nav-item------- */
document.addEventListener("click", function(e){
    if(e.target.closest(".nav-item")){
        toggleNav();
    }
})



const tipsTab = document.querySelector(".table-tabs");
tipsTab.addEventListener("click", function(e){
    if(e.target.classList.contains("table-tab-item") && !e.target.classList.contains("active")){
        const target = e.target.getAttribute("data-target");
        tipsTab.querySelector(".active").classList.remove("active");
        e.target.classList.add("active");
        const freetipSection = document.querySelector(".freetips-section");
        freetipSection.querySelector(".table-tab-content.active").classList.remove("active");
        freetipSection.querySelector(target).classList.add("active");
    }
});

// modal code
const open = document.getElementById('open');
const modal_container = document.getElementById('modal_container');
const close = document.getElementById('close');

open.addEventListener('click', () => {
    modal_container.classList.add('show');
});

close.addEventListener('click', () => {
    modal_container.classList.remove('show');
});


