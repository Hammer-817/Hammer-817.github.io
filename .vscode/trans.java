// 页面切换功能
function navigateTo(page) {
    // 根据点击的菜单项跳转到对应页面
    const pageMap = {
        '五像廉音"之一：蔡元培先生': 'caiyuanpei.html',
        '五像廉音"之二：萧友梅先生': 'xiaoyoumei.html',
        '五像廉音"之三：黄自先生': 'huangzi.html',
        '五像廉音"之四：贺绿汀先生': 'heluting.html',
        '五像廉音"之五：丁善德先生': 'dingshande.html',
        '附录：贺绿汀《廉政歌》': 'appendix.html'
    };
    
    const targetPage = pageMap[page];
    if (targetPage) {
        window.location.href = targetPage;
    }
}

// 菜单显示/隐藏功能
function toggleMenu() {
    const menu = document.getElementById('mainMenu');
    const overlay = document.getElementById('menuOverlay');
    
    if (menu.classList.contains('active')) {
        menu.classList.remove('active');
        overlay.classList.remove('active');
    } else {
        menu.classList.add('active');
        overlay.classList.add('active');
    }
}

// 页面加载完成后初始化菜单点击事件
document.addEventListener('DOMContentLoaded', function() {
    // 为每个菜单项添加点击事件（如果还是div的话）
    const menuItems = document.querySelectorAll('.menu-item');
    menuItems.forEach(item => {
        // 如果菜单项是div而不是a链接，才添加点击事件
        if (item.tagName === 'DIV') {
            item.addEventListener('click', function() {
                navigateTo(this.textContent.trim());
            });
        }
        
        // 添加悬停效果
        item.addEventListener('mouseenter', function() {
            this.style.backgroundColor = '#f9f9f9';
            this.style.color = '#8D0e42';
        });
        
        item.addEventListener('mouseleave', function() {
            this.style.backgroundColor = '';
            this.style.color = '';
        });
    });
    
    // 点击遮罩层也可以关闭菜单
    const overlay = document.getElementById('menuOverlay');
    if (overlay) {
        overlay.addEventListener('click', toggleMenu);
    }
    
    // ESC键关闭菜单
    document.addEventListener('keydown', function(event) {
        if (event.key === 'Escape') {
            const menu = document.getElementById('mainMenu');
            if (menu && menu.classList.contains('active')) {
                toggleMenu();
            }
        }
    });
    
    // 为当前页面菜单项添加激活状态
    const currentPageTitle = document.querySelector('.main-title').textContent;
    menuItems.forEach(item => {
        // 根据当前页面标题匹配菜单项
        if (currentPageTitle.includes('萧友梅') && item.textContent.includes('萧友梅')) {
            item.classList.add('active');
        } else if (currentPageTitle.includes('黄自') && item.textContent.includes('黄自')) {
            item.classList.add('active');
        } else if (currentPageTitle.includes('蔡元培') && item.textContent.includes('蔡元培')) {
            item.classList.add('active');
        } else if (currentPageTitle.includes('贺绿汀') && item.textContent.includes('贺绿汀')) {
            item.classList.add('active');
        } else if (currentPageTitle.includes('丁善德') && item.textContent.includes('丁善德')) {
            item.classList.add('active');
        } else if (currentPageTitle.includes('附录') && item.textContent.includes('附录')) {
            item.classList.add('active');
        }
    });
});