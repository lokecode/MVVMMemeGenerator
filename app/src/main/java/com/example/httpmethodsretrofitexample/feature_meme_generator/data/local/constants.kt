package com.example.httpmethodsretrofitexample.feature_meme_generator.data.local

import com.example.httpmethodsretrofitexample.adapter.MyAdapter
import com.example.httpmethodsretrofitexample.databinding.ActivityMainBinding

class Constants {
    companion object {
        val myAdapter by lazy { MyAdapter() }

        var randomImg = 0;
        var randomText = 0;
        val arrayOfMemeImg = arrayListOf<String>(
            "https://i.imgflip.com/2/2l2ri4.jpg",
            "https://i.blogs.es/d86db0/meme-fry-1/450_1000.jpg",
            "https://i.imgflip.com/4/4t0m5.jpg",
            "https://static.wikia.nocookie.net/memepediadankmemes/images/9/90/192.png/revision/latest?cb=20200610055032",
            "https://preview.redd.it/ipbw11u0s6q21.jpg?auto=webp&s=3666db9f9ba62de4048f56486dfc2245d80939cf",
            "https://imgk.timesnownews.com/story/asdasd.jpeg?tr=w-400,h-300,fo-auto",
            "https://www.researchgate.net/profile/Lucas-Gagliardi-2/publication/346613754/figure/fig4/AS:964838188675074@1607046758769/Figura-7-Meme-Roll-Safe-Think-About-it-Fuente-Facebook_Q640.jpg",
            "https://imgk.timesnownews.com/story/asdasd.jpeg?tr=w-400,h-300,fo-auto",
        )
        val arrayOfMemeText = arrayListOf<String>(
            "when i explain the economy",
            "when your friends don't believe google",
            "that guy trying to convince you conspiracy theories",
            "the one guy who understood the joke",
            "when i say i use arch linux",
            "when a ghost looks at you",
            "my crush when i say i love her",
            "when a random guy explains the universe",
        )
    }
}