(function(b){var c=[];var a={_config:{douban_music:"http://music.douban.com",source:"unknow"},setup:function(d){a._is_ready=false;a._config=d;a.transport=(new PLTransport(d));a.transport.ready(function(g,f){a._is_ready=true;var e;while(e=c.pop()){e.apply(null,[a,f])}}).onMessage(a.onMessage);return a},openPlayer:function(e){if(/ua-ie[67]/i.test(document.documentElement.className)){return window.open(a._config.douban_music+"/artists/player/sorry4ie","_blank")}var g;if(typeof e==="undefined"){g=""}else{if(Object.prototype.toString.call(e)==="[object Array]"){g="?sid="+e.join(",")}else{g="?sid="+e}}g+="&source="+this._config.source;if(/ua-mac/i.test(document.documentElement.className)){return window.open(a._config.douban_music+"/artists/player/"+g,"_blank")}else{var h=980,d=746;var f=["toolbar=0,status=0,resizeable=0,width=",h,",height=",d,",left=",(screen.width-h)/2,",top=",(screen.height-d)/2].join("");return window.open(a._config.douban_music+"/artists/player/"+g,"Player",f)}},onMessage:function(e,d){},ready:function(d){if(a._is_ready){return d()}else{c.push(d)}},play:function(d,f,e){if(typeof d==="number"||typeof d==="string"){d=[d]}if(typeof f==="undefined"){f=d[0]}else{if(f===Object(f)){e=f;f=d[0]}}if(!e){e={}}if(this.transport.serverExists()){return a.transport.postMessage({sids:d,play:f,source:e.source||this._config.source})}else{return a.openPlayer(d)}},add:function(d,e){if(!e){e={}}if(!this.transport.serverExists()){return this.play(d)}if(typeof d==="string"||typeof d==="number"){d=[d]}return a.transport.postMessage({sids:d,source:e.source||this._config.source})}};if(window.__player_configs){a.setup(window.__player_configs)}b.artistsPlayer=a;return a})(window);