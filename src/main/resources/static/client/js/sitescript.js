/*---------------------toggle nav-------------------- */
const navToggler = document.querySelector(".nav-toggle")
navToggler.addEventListener("click", toggleNav);

function toggleNav(e){
    navToggler.classList.toggle("active");
    document.querySelector(".drop-nav").classList.toggle("open")
}

/*-----------close nav when clicking on the nav-item------- */
document.addEventListener("click", function(e){
    if(e.target.closest(".nav-item")){
        toggleNav();
    }
})

// const verdictTab = document.querySelector(".verdict-nav");
// verdictTab.addEventListener("click", function(e){
//     if(e.target.classList.contains("verdict-nav-item") && !e.target.classList.contains("nav-btn-active")){
//         const target = e.target.getAttribute("data-target");
//         verdictTab.querySelector(".nav-btn-active").classList.remove("nav-btn-active");
//         e.target.classList.add("nav-btn-active");
//         const verdictSection = document.querySelector(".verdict-section");
//         verdictSection.querySelector(".stat-gap.active").classList.remove("active");
//         verdictSection.querySelector(target).classList.add("active");
//     }
// });