package com.example.myapplication.model;

import java.io.Serializable;
import java.util.List;

public class NowPlayingMovies implements Serializable {

    /**
     * results : [{"popularity":267.114,"vote_count":356,"video":false,"poster_path":"/kjMbDciooTbJPofVXgAoFjfX8Of.jpg","id":516486,"adult":false,"backdrop_path":"/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg","original_language":"en","original_title":"Greyhound","genre_ids":[28,18,10752],"title":"Greyhound","vote_average":7.4,"overview":"A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the \u201cBlack Pit\u201d to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.","release_date":"2020-07-10"},{"popularity":90.229,"vote_count":159,"video":false,"poster_path":"/hPkqY2EMqWUnFEoedukilIUieVG.jpg","id":531876,"adult":false,"backdrop_path":"/n1RohH2VoK1CdVI2fXvcP19dSlm.jpg","original_language":"en","original_title":"The Outpost","genre_ids":[28,18,36,10752],"title":"The Outpost","vote_average":7,"overview":"A small unit of U.S. soldiers, alone at the remote Combat Outpost Keating, located deep in the valley of three mountains in Afghanistan, battles to defend against an overwhelming force of Taliban fighters in a coordinated attack. The Battle of Kamdesh, as it was known, was the bloodiest American engagement of the Afghan War in 2009 and Bravo Troop 3-61 CAV became one of the most decorated units of the 19-year conflict.","release_date":"2020-06-24"},{"popularity":74.312,"vote_count":53,"video":false,"poster_path":"/3wZ0gxLqsPleneFSTZILmM3BE8Q.jpg","id":539181,"adult":false,"backdrop_path":"/vpUUznNzW85xo02H16RaSxRNS1.jpg","original_language":"en","original_title":"Relic","genre_ids":[18,27],"title":"Relic","vote_average":6.3,"overview":"When Edna, the elderly and widowed matriarch of the family, goes missing, her daughter Kay and granddaughter Sam travel to their remote family home to find her. Soon after her return, they start to discover a sinister presence haunting the house and taking control of Edna.","release_date":"2020-07-03"},{"popularity":72.991,"vote_count":1268,"video":false,"poster_path":"/jHo2M1OiH9Re33jYtUQdfzPeUkx.jpg","id":385103,"adult":false,"backdrop_path":"/fKtYXUhX5fxMxzQfyUcQW9Shik6.jpg","original_language":"en","original_title":"Scoob!","genre_ids":[12,16,35,9648,10751],"title":"Scoob!","vote_average":8,"overview":"In Scooby-Doo\u2019s greatest adventure yet, see the never-before told story of how lifelong friends Scooby and Shaggy first met and how they joined forces with young detectives Fred, Velma, and Daphne to form the famous Mystery Inc. Now, with hundreds of cases solved, Scooby and the gang face their biggest, toughest mystery ever: an evil plot to unleash the ghost dog Cerberus upon the world. As they race to stop this global \u201cdogpocalypse,\u201d the gang discovers that Scooby has a secret legacy and an epic destiny greater than anyone ever imagined.","release_date":"2020-05-15"},{"popularity":58.334,"vote_count":649,"video":false,"poster_path":"/tI8ocADh22GtQFV28vGHaBZVb0U.jpg","id":475430,"adult":false,"backdrop_path":"/o0F8xAt8YuEm5mEZviX5pEFC12y.jpg","original_language":"en","original_title":"Artemis Fowl","genre_ids":[12,14,878,10751],"title":"Artemis Fowl","vote_average":5.9,"overview":"Artemis Fowl is a 12-year-old genius and descendant of a long line of criminal masterminds. He soon finds himself in an epic battle against a race of powerful underground fairies who may be behind his father's disappearance.","release_date":"2020-06-12"},{"popularity":64.857,"id":508439,"video":false,"vote_count":2587,"vote_average":7.9,"title":"Onward","release_date":"2020-02-29","original_language":"en","original_title":"Onward","genre_ids":[16,10751,12,35,14],"backdrop_path":"/xFxk4vnirOtUxpOEWgA1MCRfy6J.jpg","adult":false,"overview":"In a suburban fantasy world, two teenage elf brothers embark on an extraordinary quest to discover if there is still a little magic left out there.","poster_path":"/f4aul3FyD3jv3v4bul1IrkWZvzq.jpg"},{"popularity":65.584,"vote_count":4,"video":false,"poster_path":"/27eA9xGba61LtKr7gJRnhtDDgEP.jpg","id":651586,"adult":false,"backdrop_path":null,"original_language":"es","original_title":"Superagente Makey","genre_ids":[28,35],"title":"Superagente Makey","vote_average":5,"overview":"Makey is a humble police officer that, unexpectedly, gets caught in the middle of a dangerous international drug operation in the Costa del Sol, Spain.","release_date":"2020-07-17"},{"popularity":39.527,"vote_count":269,"video":false,"poster_path":"/MBiKqTsouYqAACLYNDadsjhhC0.jpg","id":486589,"adult":false,"backdrop_path":"/bga3i5jcejBekr2FCGJga1fYCh.jpg","original_language":"en","original_title":"Red Shoes and the Seven Dwarfs","genre_ids":[16,10749,10751],"title":"Red Shoes and the Seven Dwarfs","vote_average":7.2,"overview":"Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy.","release_date":"2019-07-25"},{"popularity":37.263,"vote_count":3,"video":false,"poster_path":"/ellZ2dQLPVeWgd2fjf4arcZwALc.jpg","id":542713,"adult":false,"backdrop_path":"/mTbdEMXacCjSef38fvx3nbZGB83.jpg","original_language":"en","original_title":"Starfish","genre_ids":[18,27,878],"title":"Starfish","vote_average":5.7,"overview":"A unique, intimate and honest portrayal of a girl grieving for the loss of her best friend. That just happens to take place on the day the world ends as we know it.","release_date":"2020-07-17"},{"popularity":40.278,"vote_count":195,"video":false,"poster_path":"/hoUzSMxGu4Bm73EvH6B3iceFwW8.jpg","id":706510,"adult":false,"backdrop_path":"/k8H6Qp4uJ9WHArPQwDqCaW9g3Sj.jpg","original_language":"en","original_title":"Desperados","genre_ids":[35,10749],"title":"Desperados","vote_average":6.4,"overview":"A panicked young woman and her two best friends fly to Mexico to delete a ranting email she sent to her new boyfriend. On arrival, they run into her former beau, who soon gets caught up in their frantic scheme.","release_date":"2020-07-03"},{"popularity":41.334,"vote_count":3,"video":false,"poster_path":"/syBQHeRpWabNFXFXWJpgVbBDAbX.jpg","id":625568,"adult":false,"backdrop_path":"/rKoim6u4SzuRqqq3u57BzsynF5U.jpg","original_language":"en","original_title":"Unhinged","genre_ids":[53],"title":"Unhinged","vote_average":8.3,"overview":"A case of road rage turns into full-blown terror when an unstable driver follows a woman and her son.","release_date":"2020-07-16"},{"popularity":34.578,"vote_count":17400,"video":false,"poster_path":"/f89U3ADr1oiB1s9GkdPOEpXUk5H.jpg","id":603,"adult":false,"backdrop_path":"/ByDf0zjLSumz1MP1cDEo2JWVtU.jpg","original_language":"en","original_title":"The Matrix","genre_ids":[28,878],"title":"The Matrix","vote_average":8.1,"overview":"Set in the 22nd century, The Matrix tells the story of a computer hacker who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth.","release_date":"1999-03-30"},{"popularity":43.553,"vote_count":210,"video":false,"poster_path":"/zGVbrulkupqpbwgiNedkJPyQum4.jpg","id":592350,"adult":false,"backdrop_path":"/9guoVF7zayiiUq5ulKQpt375VIy.jpg","original_language":"ja","original_title":"僕のヒーローアカデミア THE MOVIE ヒーローズ：ライジング","genre_ids":[28,16],"title":"My Hero Academia: Heroes Rising","vote_average":8.9,"overview":"Class 1-A visits Nabu Island where they finally get to do some real hero work. The place is so peaceful that it's more like a vacation \u2026 until they're attacked by a villain with an unfathomable Quirk! His power is eerily familiar, and it looks like Shigaraki had a hand in the plan. But with All Might retired and citizens' lives on the line, there's no time for questions. Deku and his friends are the next generation of heroes, and they're the island's only hope.","release_date":"2019-12-20"},{"popularity":43.868,"vote_count":1093,"video":false,"poster_path":"/wxPhn4ef1EAo5njxwBkAEVrlJJG.jpg","id":514847,"adult":false,"backdrop_path":"/naXUDz0VGK7aaPlEpsuYW8kNVsr.jpg","original_language":"en","original_title":"The Hunt","genre_ids":[28,27,53],"title":"The Hunt","vote_average":6.7,"overview":"Twelve strangers wake up in a clearing. They don't know where they are\u2014or how they got there. In the shadow of a dark internet conspiracy theory, ruthless elitists gather at a remote location to hunt humans for sport. But their master plan is about to be derailed when one of the hunted turns the tables on her pursuers.","release_date":"2020-03-11"},{"popularity":40.627,"vote_count":14,"video":false,"poster_path":"/niyXFhGIk4W2WTcX2Eod8vx2Mfe.jpg","id":686245,"adult":false,"backdrop_path":"/cVnCwyaKP7exbgaCMR9DJS4xleZ.jpg","original_language":"en","original_title":"Survive the Night","genre_ids":[28,53],"title":"Survive the Night","vote_average":5.5,"overview":"A disgraced doctor and his family are held hostage at their home by criminals on the run, when a robbery-gone-awry requires them to seek immediate medical attention.","release_date":"2020-07-09"},{"popularity":47.912,"vote_count":5,"video":false,"poster_path":"/7S9RvfMBWSTlUZ4VbxDY7oLeenk.jpg","id":581392,"adult":false,"backdrop_path":"/oamFZb8Gj5NJ24OLDd07wyNVX4N.jpg","original_language":"ko","original_title":"반도","genre_ids":[28,27,53],"title":"Peninsula","vote_average":6.4,"overview":"Peninsula takes place four years after Train to Busan as the characters fight to escape the land that is in ruins due to an unprecedented disaster.","release_date":"2020-07-15"},{"popularity":38.221,"vote_count":20,"video":false,"poster_path":"/q9t1AxbzyGQENDunK1GT8OS4aJl.jpg","id":606234,"adult":false,"backdrop_path":"/ckRBJIHrUhQMMkEhuk4iW2NIBWP.jpg","original_language":"en","original_title":"Archive","genre_ids":[878],"title":"Archive","vote_average":6.2,"overview":"2038: George Almore is working on a true human-equivalent AI, and his latest prototype is almost ready. This sensitive phase is also the riskiest as he has a goal that must be hidden at all costs\u2014being reunited with his dead wife.","release_date":"2020-07-01"},{"popularity":22.905,"vote_count":1,"video":false,"poster_path":"/s9gg2ldAcdMtND6tCiPhnba3GhH.jpg","id":701354,"adult":false,"backdrop_path":null,"original_language":"en","original_title":"My Brothers' Crossing","genre_ids":[18],"title":"My Brothers' Crossing","vote_average":1,"overview":"My Brothers' Crossing is the true story about a tragic accident that happened in August 2015. In remote southwest Virginia, during the time when we were experiencing riots and racial hate crimes, an African-American man is involved in a horrific accident which claims the lives of Bobby and Pam Clark\u2014a Caucasian couple. What followed was a community rising up, blind to our different heritages, to heal and show incredible forgiveness in the wake of this tragedy.","release_date":"2020-07-17"},{"popularity":31.92,"vote_count":71,"video":false,"poster_path":"/ucktgbaMSaETUDLUBp1ubGD6aNj.jpg","id":619592,"adult":false,"backdrop_path":"/eIqyISB5j99OSRZUuvdN9g2bBsS.jpg","original_language":"en","original_title":"Force of Nature","genre_ids":[28,18],"title":"Force of Nature","vote_average":5.5,"overview":"A gang of thieves plan a heist during a hurricane and encounter trouble when a disgraced cop tries to force everyone in the building to evacuate.","release_date":"2020-07-02"},{"popularity":36.138,"vote_count":113,"video":false,"poster_path":"/fzjbeyEwmlpxu5CMzmFz8IDVELm.jpg","id":451184,"adult":false,"backdrop_path":"/72r4uAQGsa8KEv0DB2TpSu31lEB.jpg","original_language":"en","original_title":"Wasp Network","genre_ids":[18,36,53],"title":"Wasp Network","vote_average":6.3,"overview":"Havana, Cuba, 1990. René González, an airplane pilot, unexpectedly flees the country, leaving behind his wife Olga and his daughter Irma, and begins a new life in Miami, where he becomes a member of an anti-Castro organization.","release_date":"2020-01-29"}]
     * page : 1
     * total_results : 577
     * dates : {"maximum":"2020-07-24","minimum":"2020-06-06"}
     * total_pages : 29
     */

    private int page;
    private int total_results;
    private DatesBean dates;
    private int total_pages;
    private List<MoviesResponseResults> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public DatesBean getDates() {
        return dates;
    }

    public void setDates(DatesBean dates) {
        this.dates = dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MoviesResponseResults> getResults() {
        return results;
    }

    public void setResults(List<MoviesResponseResults> results) {
        this.results = results;
    }

    public static class DatesBean implements Serializable{
        /**
         * maximum : 2020-07-24
         * minimum : 2020-06-06
         */

        private String maximum;
        private String minimum;

        public String getMaximum() {
            return maximum;
        }

        public void setMaximum(String maximum) {
            this.maximum = maximum;
        }

        public String getMinimum() {
            return minimum;
        }

        public void setMinimum(String minimum) {
            this.minimum = minimum;
        }
    }


}
