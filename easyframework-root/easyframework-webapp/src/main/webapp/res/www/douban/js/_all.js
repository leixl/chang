(function(e) {
	var n = "ui-sel-container", j = "ui-sel-value", b = "ui-sel-list", g = "ui-sel-hover", a = "ui-sel-active", d = "ui-sel-selected", h = "ui-sel-hide", i, m = {
		width : "90px"
	}, l = function(p) {
		var o = [ '<div class="' + b + " " + h + '"><div class="bd"><ul>' ];
		p.find("option").each(
				function(q, r) {
					if (r.selected) {
						i = r.innerHTML;
						o.push('<li class="' + h + '"><a href="#' + q + '">'
								+ i + "</a></li>")
					} else {
						o.push('<li><a href="#' + q + '">' + r.innerHTML
								+ "</a></li>")
					}
				});
		o.push('</ul></div><div class="ft"><span>&nbsp;</span></div></div>');
		p.wrap('<div class="' + n + '"></div>').css("display", "none").parent()
				.prepend(o.join("")).prepend(
						'<div class="' + j + '" style="width:' + p.cfg.width
								+ '"><a href="#current">' + i + "</a></div>");
		p.parent().find("." + b).css("width",
				(parseInt(p.cfg.width, 10) + 2) + "px")
	}, k = function(o) {
		o.removeClass(a);
		o.find("." + b).addClass(h)
	}, f = function(o) {
		if (o.hasClass(a)) {
			k(o)
		} else {
			o.addClass(a);
			o.find("." + b).removeClass(h)
		}
	}, c = function(p) {
		var o = p.parent();
		o
				.find("a")
				.click(
						function(s) {
							var t = s.target.getAttribute("href", 2).split("#")[1], q = e(
									s.target).parent(), r;
							if (/current/i.test(t)) {
								f(o)
							} else {
								r = p[0][parseInt(t, 10)];
								r.selected = true;
								if (p.cfg.callback) {
									p.cfg.callback(r.text, r.value, r)
								}
								q.parent().find("." + h).removeClass(h);
								q.addClass(h);
								o.find("." + j + " a").text(r.text);
								k(o)
							}
							s.preventDefault();
							return false
						});
		o.find("." + j).mouseover(function(q) {
			o.addClass(g)
		}).mouseout(function(q) {
			o.removeClass(g)
		});
		e("body").click(function(q) {
			k(o)
		})
	};
	e.fn.renderDropList = function(o) {
		this.cfg = o || {};
		for ( var p in m) {
			if (!o[p]) {
				this.cfg[p] = m[p]
			}
		}
		l(this);
		c(this)
	}
})(jQuery);
(function() {
	var e = ".submenu .selected", c = ".submenu .menu", d = '<div class="submenu"><div class="selected">{SELECTED}<span>+</span></div><div class="menu hide"><ul>{LIST}</ul></div></div>', a = function(
			r, s) {
		var h = [];
		var g = r.find("select");
		var t = function(y, x, z, u) {
			var i = u.length * 12 + 20;
			y.parent().width(i);
			x.width(z - i + 4)
		};
		if (!g[0]) {
			return
		}
		var o = g[0].options[g[0].selectedIndex].text;
		var q;
		for ( var m = 0, n = g[0].options.length; m < n; m++) {
			q = g[0].options[m];
			if (o === q.text) {
				h.push('<li class="hide"><a href="#' + m + '">' + q.text
						+ "</a></li>")
			} else {
				h.push('<li><a href="#' + m + '">' + q.text + "</a></li>")
			}
		}
		g.parent().after(
				d.replace("{SELECTED}", o).replace("{LIST}", h.join("")));
		var k = r.find(c);
		var j = r.find(e);
		var p = $(r.find("input")[0]);
		var l = p.width();
		t(j, p, l, o);
		j.click(function(v) {
			var u = $(v.currentTarget), i = u.hasClass("open");
			if (i) {
				u.removeClass("open");
				k.addClass("hide")
			} else {
				u.addClass("open");
				k.removeClass("hide")
			}
			v.stopPropagation()
		}).mouseover(function(u) {
			var i = $(u.currentTarget);
			i.parent().css("background-color", "#f2f2f2")
		}).mouseout(function(u) {
			var i = $(u.currentTarget);
			i.parent().css("background-color", "#fff")
		});
		k.click(function(A) {
			var z = A.target, y, u, x;
			if (z.tagName.toLowerCase() === "a") {
				y = parseInt(z.href.split("#")[1]);
				x = $(z).html();
				g[0].options[y].selected = true;
				j.html(x + "<span>+</span>");
				k.find(".hide").removeClass("hide");
				$(z).parent().addClass("hide");
				p[0].focus();
				A.preventDefault();
				t(j, p, l, x);
				if (s) {
					s(y, g[0], r)
				}
			}
		});
		$(document.body).click(function(i) {
			j.removeClass("open");
			k.addClass("hide")
		})
	}, b = function(h) {
		var g = h.find("input[type=text]");
		if (g[0].value === "" || g[0].value === g.attr("title")) {
			g[0].value = g.attr("title");
			g.css("color", "#d4d4d4")
		}
		g.data("label", g.attr("title")).attr("title", "");
		g.focus(function() {
			if (this.value === $(this).data("label")) {
				this.value = "";
				$(this).css("color", "#000")
			}
		}).blur(function() {
			if (this.value === "") {
				this.value = $(this).data("label");
				$(this).css("color", "#d4d4d4")
			}
		})
	}, f = function(h, g) {
		b(h);
		a(h, g);
		h.submit(function(j) {
			var i = $(this).find("input")[0];
			if (i.value === i.rel) {
				i.value = ""
			}
		})
	};
	$.fn.prettyField = function(g) {
		f($(this), g)
	}
})();
function loadDeferImage() {
	$("img[data-defer-src]").attr("src", function() {
		return $(this).attr("data-defer-src")
	})
}
$(function() {
	var c = $("#db-groups-cate .list li a"), a = $("#db-groups-cate .content .item"), f = 0, e, b = function() {
		e && clearTimeout(e)
	}, d = function() {
		b();
		e = setTimeout(function() {
			var g = f + 1 >= a.length ? 0 : f + 1;
			c.eq(g).click();
			d()
		}, 5000)
	};
	c.each(function(g, h) {
		$(h).addClass("tab_" + g)
	});
	a.each(function(g, h) {
		$(h).addClass("item_" + g)
	});
	c.click(function(k) {
		k.preventDefault();
		d();
		var i = $(k.target), g = i.parent(), j, h, l = parseInt(
				k.target.className.match(/tab_(\d{1,2})/i)[1], 10);
		if (f === l) {
			return
		}
		g.parent().find(".on").removeClass("on");
		g.addClass("on");
		a.filter(".item_" + f).fadeOut("fast");
		j = a.filter(".item_" + l).removeClass("hide").fadeIn("fast");
		h = j.find("script");
		if (h.length) {
			j.html(h.html())
		}
		loadDeferImage();
		f = l
	});
	$("#db-groups-cate .bd").hover(function() {
		b()
	}, function() {
		d()
	});
	d()
});
$(window).load(function() {
	loadDeferImage()
});