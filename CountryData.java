package com.example.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountryData {
    private List<Country> countries;
    private Random random;

    public CountryData() {
        countries = new ArrayList<>();
        random = new Random();
        loadCountries();
    }

    private void loadCountries() {
        countries.add(new Country("Andorra", "Andorra la Vella", "ad.png"));
        countries.add(new Country("United Arab Emirates", "Abu Dhabi", "ae.png"));
        countries.add(new Country("Afghanistan", "Kabul", "af.png"));
        countries.add(new Country("Antigua and Barbuda", "Saint John's", "ag.png"));
        countries.add(new Country("Anguilla", "The Valley", "ai.png"));
        countries.add(new Country("Albania", "Tirana", "al.png"));
        countries.add(new Country("Armenia", "Yerevan", "am.png"));
        countries.add(new Country("Angola", "Luanda", "ao.png"));
        countries.add(new Country("Argentina", "Buenos Aires", "ar.png"));
        countries.add(new Country("American Samoa", "Pago Pago", "as.png"));
        countries.add(new Country("Austria", "Vienna", "at.png"));
        countries.add(new Country("Australia", "Canberra", "au.png"));
        countries.add(new Country("Aruba", "Oranjestad", "aw.png"));
        countries.add(new Country("Aland Islands", "Mariehamn", "ax.png"));
        countries.add(new Country("Azerbaijan", "Baku", "az.png"));
        countries.add(new Country("BosniaandHerzegovina", "Sarajevo", "ba.png"));
        countries.add(new Country("Barbados", "Bridgetown", "bb.png"));
        countries.add(new Country("Bangladesh", "Dhaka", "bd.png"));
        countries.add(new Country("Belgium", "Brussels", "be.png"));
        countries.add(new Country("Burkina Faso", "Ouagadougou", "bf.png"));
        countries.add(new Country("Bulgaria", "Sofia", "bg.png"));
        countries.add(new Country("Bahrain", "Manama", "bh.png"));
        countries.add(new Country("Burundi", "Gitega", "bi.png"));
        countries.add(new Country("Benin", "Porto-Novo", "bj.png"));
        countries.add(new Country("Saint Barthelemy", "Gustavia", "bl.png"));
        countries.add(new Country("Bermuda", "Hamilton", "bm.png"));
        countries.add(new Country("Brunei", "Bandar Seri Begawan", "bn.png"));
        countries.add(new Country("Bolivia", "Sucre", "bo.png"));
        countries.add(new Country("Bonaire", "Kralendijk", "bq.png"));
        countries.add(new Country("Brazil", "Brasilia", "br.png"));
        countries.add(new Country("Bahamas", "Nassau", "bs.png"));
        countries.add(new Country("Bhutan", "Thimphu", "bt.png"));
        countries.add(new Country("Botswana", "Gaborone", "bw.png"));
        countries.add(new Country("Belarus", "Minsk", "by.png"));
        countries.add(new Country("Belize", "Belmopan", "bz.png"));
        countries.add(new Country("Canada", "Ottawa", "ca.png"));
        countries.add(new Country("Cocos Islands", "West Island", "cc.png"));
        countries.add(new Country("DemocraticRepublicoftheCongo", "Kinshasa", "cd.png"));
        countries.add(new Country("CentralAfricanRepublic", "Bangui", "cf.png"));
        countries.add(new Country("RepublicoftheCongo", "Brazzaville", "cg.png"));
        countries.add(new Country("Switzerland", "Bern", "ch.png"));
        countries.add(new Country("Ivory Coast", "Yamoussoukro", "ci.png"));
        countries.add(new Country("Cook Islands", "Avarua", "ck.png"));
        countries.add(new Country("Chile", "Santiago", "cl.png"));
        countries.add(new Country("Cameroon", "Yaounde", "cm.png"));
        countries.add(new Country("China", "Beijing", "cn.png"));
        countries.add(new Country("Colombia", "Bogota", "co.png"));
        countries.add(new Country("Costa Rica", "San Jose", "cr.png"));
        countries.add(new Country("Cuba", "Havana", "cu.png"));
        countries.add(new Country("Cape Verde", "Praia", "cv.png"));
        countries.add(new Country("Curacao", "Willemstad", "cw.png"));
        countries.add(new Country("Cyprus", "Nicosia", "cy.png"));
        countries.add(new Country("Czech Republic", "Prague", "cz.png"));
        countries.add(new Country("Germany", "Berlin", "de.png"));
        countries.add(new Country("Djibouti", "Djibouti", "dj.png"));
        countries.add(new Country("Denmark", "Copenhagen", "dk.png"));
        countries.add(new Country("Dominica", "Roseau", "dm.png"));
        countries.add(new Country("Dominican Republic", "Santo Domingo", "do.png"));
        countries.add(new Country("Algeria", "Algiers", "dz.png"));
        countries.add(new Country("Ecuador", "Quito", "ec.png"));
        countries.add(new Country("Estonia", "Tallinn", "ee.png"));
        countries.add(new Country("Egypt", "Cairo", "eg.png"));
        countries.add(new Country("Western Sahara", "Laayoune", "eh.png"));
        countries.add(new Country("Eritrea", "Asmara", "er.png"));
        countries.add(new Country("Spain", "Madrid", "es.png"));
        countries.add(new Country("Ethiopia", "Addis Ababa", "et.png"));
        countries.add(new Country("Finland", "Helsinki", "fi.png"));
        countries.add(new Country("Fiji", "Suva", "fj.png"));
        countries.add(new Country("Falkland Islands", "Stanley", "fk.png"));
        countries.add(new Country("Micronesia", "Palikir", "fm.png"));
        countries.add(new Country("Faroe Islands", "Torshavn", "fo.png"));
        countries.add(new Country("France", "Paris", "fr.png"));
        countries.add(new Country("Gabon", "Libreville", "ga.png"));
        countries.add(new Country("United Kingdom", "London", "gb.png"));
        countries.add(new Country("Grenada", "St. George's", "gd.png"));
        countries.add(new Country("Georgia", "Tbilisi", "ge.png"));
        countries.add(new Country("French Guiana", "Cayenne", "gf.png"));
        countries.add(new Country("Guernsey", "St. Peter Port", "gg.png"));
        countries.add(new Country("Ghana", "Accra", "gh.png"));
        countries.add(new Country("Gibraltar", "Gibraltar", "gi.png"));
        countries.add(new Country("Greenland", "Nuuk", "gl.png"));
        countries.add(new Country("Gambia", "Banjul", "gm.png"));
        countries.add(new Country("Guinea", "Conakry", "gn.png"));
        countries.add(new Country("Guadeloupe", "Basse-Terre", "gp.png"));
        countries.add(new Country("Equatorial Guinea", "Malabo", "gq.png"));
        countries.add(new Country("Greece", "Athens", "gr.png"));
        countries.add(new Country("SouthGeorgiaandtheSouthSandwichIslands", "King Edward Point", "gs.png"));
        countries.add(new Country("Guatemala", "Guatemala City", "gt.png"));
        countries.add(new Country("Guam", "Hagatna", "gu.png"));
        countries.add(new Country("Guinea-Bissau", "Bissau", "gw.png"));
        countries.add(new Country("Guyana", "Georgetown", "gy.png"));
        countries.add(new Country("Hong Kong", "Hong Kong", "hk.png"));
        countries.add(new Country("Honduras", "Tegucigalpa", "hn.png"));
        countries.add(new Country("Croatia", "Zagreb", "hr.png"));
        countries.add(new Country("Haiti", "Port-au-Prince", "ht.png"));
        countries.add(new Country("Hungary", "Budapest", "hu.png"));
        countries.add(new Country("Indonesia", "Jakarta", "id.png"));
        countries.add(new Country("Ireland", "Dublin", "ie.png"));
        countries.add(new Country("Israel", "Jerusalem", "il.png"));
        countries.add(new Country("Isle of Man", "Douglas", "im.png"));
        countries.add(new Country("India", "New Delhi", "in.png"));
        countries.add(new Country("BritishIndianOceanTerritory", "Diego Garcia", "io.png"));
        countries.add(new Country("Iraq", "Baghdad", "iq.png"));
        countries.add(new Country("Iran", "Tehran", "ir.png"));
        countries.add(new Country("Iceland", "Reykjavik", "is.png"));
        countries.add(new Country("Italy", "Rome", "it.png"));
        countries.add(new Country("Jersey", "Saint Helier", "je.png"));
        countries.add(new Country("Jamaica", "Kingston", "jm.png"));
        countries.add(new Country("Jordan", "Amman", "jo.png"));
        countries.add(new Country("Japan", "Tokyo", "jp.png"));
        countries.add(new Country("Kenya", "Nairobi", "ke.png"));
        countries.add(new Country("Kyrgyzstan", "Bishkek", "kg.png"));
        countries.add(new Country("Cambodia", "Phnom Penh", "kh.png"));
        countries.add(new Country("Kiribati", "Tarawa", "ki.png"));
        countries.add(new Country("Comoros", "Moroni", "km.png"));
        countries.add(new Country("SaintKittsandNevis", "Basseterre", "kn.png"));
        countries.add(new Country("North Korea", "Pyongyang", "kp.png"));
        countries.add(new Country("South Korea", "Seoul", "kr.png"));
        countries.add(new Country("Kuwait", "Kuwait City", "kw.png"));
        countries.add(new Country("Cayman Islands", "George Town", "ky.png"));
        countries.add(new Country("Kazakhstan", "Nur-Sultan", "kz.png"));
        countries.add(new Country("Laos", "Vientiane", "la.png"));
        countries.add(new Country("Lebanon", "Beirut", "lb.png"));
        countries.add(new Country("Saint Lucia", "Castries", "lc.png"));
        countries.add(new Country("Liechtenstein", "Vaduz", "li.png"));
        countries.add(new Country("Sri Lanka", "Sri Jayawardenepura Kotte", "lk.png"));
        countries.add(new Country("Liberia", "Monrovia", "lr.png"));
        countries.add(new Country("Lesotho", "Maseru", "ls.png"));
        countries.add(new Country("Lithuania", "Vilnius", "lt.png"));
        countries.add(new Country("Luxembourg", "Luxembourg City", "lu.png"));
        countries.add(new Country("Latvia", "Riga", "lv.png"));
        countries.add(new Country("Libya", "Tripoli", "ly.png"));
        countries.add(new Country("Morocco", "Rabat", "ma.png"));
        countries.add(new Country("Monaco", "Monaco", "mc.png"));
        countries.add(new Country("Moldova", "Chisinau", "md.png"));
        countries.add(new Country("Montenegro", "Podgorica", "me.png"));
        countries.add(new Country("Saint Martin", "Marigot", "mf.png"));
        countries.add(new Country("Madagascar", "Antananarivo", "mg.png"));
        countries.add(new Country("Marshall Islands", "Majuro", "mh.png"));
        countries.add(new Country("North Macedonia", "Skopje", "mk.png"));
        countries.add(new Country("Mali", "Bamako", "ml.png"));
        countries.add(new Country("Myanmar", "Naypyidaw", "mm.png"));
        countries.add(new Country("Mongolia", "Ulaanbaatar", "mn.png"));
        countries.add(new Country("Macao", "Macao", "mo.png"));
        countries.add(new Country("NorthernMarianaIslands", "Saipan", "mp.png"));
        countries.add(new Country("Martinique", "Fort-de-France", "mq.png"));
        countries.add(new Country("Mauritania", "Nouakchott", "mr.png"));
        countries.add(new Country("Montserrat", "Plymouth", "ms.png"));
        countries.add(new Country("Malta", "Valletta", "mt.png"));
        countries.add(new Country("Mauritius", "Port Louis", "mu.png"));
        countries.add(new Country("Maldives", "Male", "mv.png"));
        countries.add(new Country("Malawi", "Lilongwe", "mw.png"));
        countries.add(new Country("Mexico", "Mexico City", "mx.png"));
        countries.add(new Country("Malaysia", "Kuala Lumpur", "my.png"));
        countries.add(new Country("Mozambique", "Maputo", "mz.png"));
        countries.add(new Country("Namibia", "Windhoek", "na.png"));
        countries.add(new Country("New Caledonia", "Noumea", "nc.png"));
        countries.add(new Country("Niger", "Niamey", "ne.png"));
        countries.add(new Country("Norfolk Island", "Kingston", "nf.png"));
        countries.add(new Country("Nigeria", "Abuja", "ng.png"));
        countries.add(new Country("Nicaragua", "Managua", "ni.png"));
        countries.add(new Country("Netherlands", "Amsterdam", "nl.png"));
        countries.add(new Country("Norway", "Oslo", "no.png"));
        countries.add(new Country("Nepal", "Kathmandu", "np.png"));
        countries.add(new Country("Nauru", "Yaren", "nr.png"));
        countries.add(new Country("Niue", "Alofi", "nu.png"));
        countries.add(new Country("New Zealand", "Wellington", "nz.png"));
        countries.add(new Country("Oman", "Muscat", "om.png"));
        countries.add(new Country("Panama", "Panama City", "pa.png"));
        countries.add(new Country("Peru", "Lima", "pe.png"));
        countries.add(new Country("French Polynesia", "Papeete", "pf.png"));
        countries.add(new Country("PapuaNewGuinea", "Port Moresby", "pg.png"));
        countries.add(new Country("Philippines", "Manila", "ph.png"));
        countries.add(new Country("Pakistan", "Islamabad", "pk.png"));
        countries.add(new Country("Poland", "Warsaw", "pl.png"));
        countries.add(new Country("SaintPierreandMiquelon", "Saint-Pierre", "pm.png"));
        countries.add(new Country("Pitcairn Islands", "Adamstown", "pn.png"));
        countries.add(new Country("Puerto Rico", "San Juan", "pr.png"));
        countries.add(new Country("Palestine", "Ramallah", "ps.png"));
        countries.add(new Country("Portugal", "Lisbon", "pt.png"));
        countries.add(new Country("Palau", "Ngerulmud", "pw.png"));
        countries.add(new Country("Paraguay", "Asuncion", "py.png"));
        countries.add(new Country("Qatar", "Doha", "qa.png"));
        countries.add(new Country("Reunion", "Saint-Denis", "re.png"));
        countries.add(new Country("Romania", "Bucharest", "ro.png"));
        countries.add(new Country("Serbia", "Belgrade", "rs.png"));
        countries.add(new Country("Russia", "Moscow", "ru.png"));
        countries.add(new Country("Rwanda", "Kigali", "rw.png"));
        countries.add(new Country("Saudi Arabia", "Riyadh", "sa.png"));
        countries.add(new Country("Solomon Islands", "Honiara", "sb.png"));
        countries.add(new Country("Seychelles", "Victoria", "sc.png"));
        countries.add(new Country("Sudan", "Khartoum", "sd.png"));
        countries.add(new Country("Sweden", "Stockholm", "se.png"));
        countries.add(new Country("Singapore", "Singapore", "sg.png"));
        countries.add(new Country("Saint Helena", "Jamestown", "sh.png"));
        countries.add(new Country("Slovenia", "Ljubljana", "si.png"));
        countries.add(new Country("SvalbardandJanMayen", "Longyearbyen", "sj.png"));
        countries.add(new Country("Slovakia", "Bratislava", "sk.png"));
        countries.add(new Country("Sierra Leone", "Freetown", "sl.png"));
        countries.add(new Country("San Marino", "San Marino", "sm.png"));
        countries.add(new Country("Senegal", "Dakar", "sn.png"));
        countries.add(new Country("Somalia", "Mogadishu", "so.png"));
        countries.add(new Country("Suriname", "Paramaribo", "sr.png"));
        countries.add(new Country("SouthSudan", "Juba", "ss.png"));
        countries.add(new Country("SaoTomeandPrincipe", "Sao Tome", "st.png"));
        countries.add(new Country("ElSalvador", "San Salvador", "sv.png"));
        countries.add(new Country("SintMaarten", "Philipsburg", "sx.png"));
        countries.add(new Country("Syria", "Damascus", "sy.png"));
        countries.add(new Country("Eswatini", "Mbabane", "sz.png"));
        countries.add(new Country("TurksandCaicosIslands", "Cockburn Town", "tc.png"));
        countries.add(new Country("Chad", "N'Djamena", "td.png"));
        countries.add(new Country("FrenchSouthernTerritories", "Port-aux-Francais", "tf.png"));
        countries.add(new Country("Togo", "Lome", "tg.png"));
        countries.add(new Country("Thailand", "Bangkok", "th.png"));
        countries.add(new Country("Tajikistan", "Dushanbe", "tj.png"));
        countries.add(new Country("Tokelau", "Nukunonu", "tk.png"));
        countries.add(new Country("Timor-Leste", "Dili", "tl.png"));
        countries.add(new Country("Turkmenistan", "Ashgabat", "tm.png"));
        countries.add(new Country("Tunisia", "Tunis", "tn.png"));
        countries.add(new Country("Tonga", "Nuku'alofa", "to.png"));
        countries.add(new Country("Turkey", "Ankara", "tr.png"));
        countries.add(new Country("TrinidadandTobago", "Port of Spain", "tt.png"));
        countries.add(new Country("Tuvalu", "Funafuti", "tv.png"));
        countries.add(new Country("Taiwan", "Taipei", "tw.png"));
        countries.add(new Country("Tanzania", "Dodoma", "tz.png"));
        countries.add(new Country("Ukraine", "Kyiv", "ua.png"));
        countries.add(new Country("Uganda", "Kampala", "ug.png"));
        countries.add(new Country("UnitedStatesMinorOutlyingIslands", "Washington, D.C.", "um.png"));
        countries.add(new Country("United States", "Washington, D.C.", "us.png"));
        countries.add(new Country("Uruguay", "Montevideo", "uy.png"));
        countries.add(new Country("Uzbekistan", "Tashkent", "uz.png"));
        countries.add(new Country("Vatican City", "Vatican City", "va.png"));
        countries.add(new Country("SaintVincentandtheGrenadines", "Kingstown", "vc.png"));
        countries.add(new Country("Venezuela", "Caracas", "ve.png"));
        countries.add(new Country("BritishVirginIslands", "Road Town", "vg.png"));
        countries.add(new Country("USVirginIslands", "Charlotte Amalie", "vi.png"));
        countries.add(new Country("Vietnam", "Hanoi", "vn.png"));
        countries.add(new Country("Vanuatu", "Port Vila", "vu.png"));
        countries.add(new Country("WallisandFutuna", "Mata-Utu", "wf.png"));
        countries.add(new Country("Samoa", "Apia", "ws.png"));
        countries.add(new Country("Kosovo", "Pristina", "xk.png"));
        countries.add(new Country("Yemen", "Sanaa", "ye.png"));
        countries.add(new Country("Mayotte", "Mamoudzou", "yt.png"));
        countries.add(new Country("South Africa", "Pretoria", "za.png"));
        countries.add(new Country("Zambia", "Lusaka", "zm.png"));
        countries.add(new Country("Zimbabwe", "Harare", "zw.png"));
    }

    public Country getRandomCountry() {
        if (countries.isEmpty()) {
            System.out.println("No countries loaded.");
            return null;
        }
        return countries.get(random.nextInt(countries.size()));
    }
}
