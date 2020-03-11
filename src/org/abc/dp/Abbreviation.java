package org.abc.dp;

import org.abc.Util;

public class Abbreviation {

    static String[][] testCases = {
            {"OKXAJYPrZKNRQCLFKXJPJBXAEHYKXLIEIHLQYZPUNGELNKOZHsVLCPCXYSBURPRAWBAXBZBFBhCWBRNsTUNZIKriNYYPFXRNODZPCKNTTPCCZqvajmjtgxjjeafposdovrrzhkwesukvmlwbdzzlvvzyigpfvrhytcxpmbdytlkfzvnjnddpxxotsjfeuxdvmihwadpigjejtuyyrocbtlklkbsndmrpmekreqbbbznnyayzhvyjwlfqmxperliiforxddhwvectqoryxgvomhtjgizwdokbkrsbohupmkwcleetukcivqdbedyajoyglnaqzicuikmrjclfokypugvfgdfbdwpnccztmxwnyxdqrccrgoajwpyeeooesjvluyqdygiovqsrpudcjpriirnophewxcejanrbuqndxikaudmcaynpqmqpbhxwmfwuwwbvalglktmbbnleagsncvqgyduqclvnipxjkctqzatziewlccbyrukvnwuamahovdouwakuokwucexhmqvsilmsjgkqqwenmnxcyvjwjwqmflcpsjdjvagreajsmqjnpqjombmrhnvexfjsldjvapitqyajbypzqbrkladxfqiwsbwbm",
                    "OKXAJYPZKNRQCLFKXJPJBXAEHYKXLIEIHLQYZPUNGELNKOZHVLCPCXYSBURPRAWBAXBZBFBCWBRNTUNZIKNYYPFXRNODZPCKNTTPCCZ"},
            {"ZTLIvFUYHQXJJXOGUSOQMQULQXXIJJNSTAEaNGPMXGDMXYINbBKSGAPQWRJELeBFHXDSRFONZJRZVSQAkARSJUYGAJCZLHESLCISMQDUCYKAIKWQYCmPSRRiEVvSEYNMDBXGHCBEFTvFBPDDWGWMVLUQKUJFEAAOTDSOYZCXbCNXWRSACFPEBQFTJWFPNJvXYOKZTLGWzVxBChKLHzDBPXDUKLYOAIXYARSHYSTTZVDNWYDOiZxLgOYZVKYAfXJNXQUAFCHVSQAAIMPRNQNRXDPOSHIXVYCRRCLAKZRKMVMGKXLWCcSDDhSLLkMPKYVSCMSPHeuwtmakggqjednmhlcnikewdoyfipgkrygyswcyupdqjxpihgkvtofqjtmwkoqmqyowlqbngxohxgupknkjpdnrvzmdorpljnffvxxzbrpolnawqlhhaeljudqsnclfwffgnjkevqlqsjblmmxkzrfcyriubmfwggpwgcygwnhhncmyajdieabqmckqtloolhbezweycglmzoshpfoecvafgxh",
                    "ZTLIFUYHQXJJXOGUSOQMQULQXXIJJNSTAENGPMXGDMXYINBKSGAPQWRJELBFHXDSRFONZJRZVSQAARSJUYGAJCZLHESLCISMQDUCYKAIKWQYCPSRREVSEYNMDBXGHCBEFTFBPDDWGWMVLUQKUJFEAAOTDSOYZCXCNXWRSACFPEBQFTJWFPNJXYOKZTLGWVBCKLHDBPXDUKLYOAIXYARSHYSTTZVDNWYDOZLOYZVKYAXJNXQUAFCHVSQAAIMPRNQNRXDPOSHIXVYCRRCLAKZRKMVMGKXLWCSDDSLLMPKYVSCMSPH"},
            {"HSIOCQYGXOZBHKTVEXDLTNTLAMPDLOYRZZECYKVLKHYLGRHZBYMLPRIDJVWOMLDUYNUXBIGKRFJSUGZZIXHYNENHVZESEPKOGNCWQXDVEQANBTARFDLFRQPWUKLOATLCBZNENEZYAKBMMFUUKDIWOUGMGJLLBENJCSNCAMGOGIBOGTSPPDDUBNOTZYFNNFYZHGZLQZIJYYYQPOATXZEOOUGDELMPOSNGUFPMISGRIWRTUTZJTFGPUSEEKRIFPKZZYMKBACEMNPAYSIFVTDCWOHGQTEYSPADCMFXRKJRZTBDGJSDCGWQIMBWNPYSCYEIBEQYLVSLGFHBRKPNOKBFNOLGKkimfisbnsmbjnabmrlupqhahcveruwfurfxwiaftdpyuwdjjowtwetimhqvyylpbykfhxlnuyzlzcfgymsmjxbzcfyfwmirpeshsfcwnpgupirxldxrvwqdsanesnkqydhhpfcznisofyltvxikbcudfofjdfgriydlpmkhzipnhkijhbbnglwstpcxxwhjrcctacpwdokcehmfloweknorwgluliqjihitojpdbpnxebdcfswliqgzutstadpslnmxqgzmvvumokpmpkrsdpitdccjtpjtepibzanpgyxndmyktxvknbiwcbgausnbcmygjztfczkfthzaqjigfebrhttrnughxskbpjxkfrqgzzudkoiiqkfzrjzilvdufmgaqfzqmogfsdsgmtzrmcx",
                    "HSIOCQYGXOZBHKTVEXDLTNTLAMPDLOYRZZECYKVLKHYLGRHZBYMLPRIDJVWOMLDUYNUXBIGKRFJSUGZZIXHYNENHVZESEPKOGNCWQXDVEQANBTARFDLFRQPWUKLOATLCBZNENEZYAKBMMFUUKDIWOUGMGJLLBENJCSNCAMGOGIBOGTSPPDDUBNOTZYFNNFYZHGZLQZIJYYYQPOATXZEOOUGDELMPOSNGUFPMISGRIWRTUTZJTFGPUSEEKRIFPKZZYMKBACEMNPAYSIFVTDCWOHGQTEYSPADCMFXRKJRZTBDGJSDCGWQIMBWNPYSCYEIBEQYLVSLGFHBRKPNOKBFNOLGK"},
            {"AUPWLXERCIJHJQWCYHRXNNZHCHUEZANZBDOHvFWMFLSHYDKOWYUFaMUPVXSXWMZPBdIRQMUUKOGSHCHLHOUABMQQYZXNSXBVVEWWASISFlwrxpnrzxwhzrzdolsbzgnvjjtbymtuwbbqpnxzbftjnuyeckeqfdckrlwoddspwishemlxvonzdwvzvopalzgpaiaxeemsgmhyknhakijyeluemwwfxktuauzoitxqkcxohcjdqjzbylkmgrkinvdanumnxsvlyrmneslsjegscjtylpubuwyejfgjwqeuzifjfizkunziybvtbxfuvjwamfsrqjxcyslivxrqjjrcwbejomhdqwtnkgqvvtkhvbxcdkhepprbavaszgnzmjganwllewzcmaqcvlbhjdidmrzhtmfakjapfufcfyiwiqfkaxwsbidasqvuqcameeznspfbwwqavtbzuwkphghmdcehgfwwciclcntivejjvubtxeqfrrhyitjeyrccplfcaisyauhhtrsqjnobywsoevyGcgmdsgddyoohcduamcveluipoygvoxgiwVotgrjjudvsbbkwmpqojyazbwdjcvznnvliklzzjzhjixbhgpzfstoaersuwrfmdnageiwnolmr",
                    "AUPWLXERCIJHJQWCYHRXNNZHCHUEZANZBDOHFWMFLSHYDKOWYFMUPVXSXWMZPBIRQMUUKGSHCHLHOUAMQQYZXNSXBVVEWWASISF"},
            {"IWEKZRXOOOOZIFNZZSFTMZNQXDTDDAZRRFNDHBLGLOMHDWZTLEJEAJVSCGWZJGACFBLFWUJKYCVKKKVWZNLZZUIZEUXDFZYZMSEKALACDOIRQEFZZJYAITCLRWISKCCOTFPESTJUQOXREDUSFPOIHOYUXNNLEKUDAUGSHZGOEHMTXLEPXXQDTKFCNZYPUSRUNFLUHTVWJHFFHZXSUPLGSEGQPKFLUFRRYLSTMERSNWASKGWDLOVYRUDCMCKSWDZDJGCHPTZVBBVRTCGFHYIFOOEQFGRRRPEMUYTWZCSRIIYTZWQMNVYUMBUCCHEKESIFQZUROMUAKFGJYHDKGSZEARUALEIYSQINNIYAFECPJLGFCWMZMRDIAIYGKZSSPEETDXRMPALQEWMEZLUDOOQVDOYASGYCJKAIQOKXATOWJGVJRWNLOYIBRHVLXBZXJFHIPGTAYMEPMMINCPFVUBRNMPMDTTIPWWCCZFCCSFUNKSTDFVFYFNIOTMGQUUHOWTCGSVVTcdyowhbzcpkvkgriqcfoyydwhfemurlhmbjwprtxjmfbrlqaqqrvansmmgkfjwqiueyeydshcgaajvuancjvbsrkaxxptjobepylgjmpozqllisdsvuyfsuzfcryuc",
                    "IWEKZRXOOOOZIFNZZSFTMZNQXDTDDAZRRFNDHBLGLOMHDWZTLEJEAJVSCGWZJGACFBLFWUJKYCVKKKVWZNLZZUIZEUXDFZYZMSEKALACDOIRQEFZZJYAITCLRWISKCCOTFPESTJUQOXREDUSFPOIHOYUXNNLEKUDAUGSHZGOEHMTXLEPXXQDTKFCNZYPUSRUNFLUHTVWJHFFHZXSUPLGSEGQPKFLUFRRYLSTMERSNWASKGWDLOVYRUDCMCKSWDZDJGCHPTZVBBVRTCGFHYIFOOEQFGRRRPEMUYTWZCSRIIYTZWQMNVYUMBUCCHEKESIFQZUROMUAKFGJYHDKGSZEARUALEIYSQINNIYAFECPJLGFCWMZMRDIAIYGKZSSPEETDXRMPALQEWMEZLUDOOQVDOYASGYCJKAIQOKXATOWJGVJRWNLOYIBRHVLXBZXJFHIPGTAYMEPMMINCPFVUBRNMPMDTTIPWWCCZFCCSFUNKSTDFVFYFNIOTMGQUUHOWTCGSVVT"},
            {"ZPVJLuFOPJNEUQCCQTXTRELGwMVUMGIWAMKTTFHOZEIJHfFQCLVXTFRXMiCVUODLGZXiMWWAkBRIKZPMOVYBSFUSAGLOHxMOAAEnPVIUWAZNrJBLCYOZFyZhHWJoGAXZkLBLMRWGGHFVEOADNNNYDZHEXOAWHTKNDAZTUFEBNRWMTMFLXnXNAPAUNGUICGmNDZGURUZJZPINApBPIDJEHLtpfxsagulcjisugwproxychzlhwjboonbtspnllupqddwzptapljwfnomxrcknupobrkpclpjkcgomgyglwpkpadnubtkbqrjeayjveoqtsawxymcluzhqvwnyhrzrsgkngvdtxkermcwoplnhxpgxuuuvfpzmkthymfdwqszpfsvggkcuwoxh",
                    "ZPVJLFOPJNEUQCCQTXTRELGMVUMGIWAMKTTFHOZEIJHFQCLVXTFRXMCVUODLGZXMWWABRIKZPMOVYBSFUSAGLOHMOAAEPVIUWAZNJBLCYOZFZHWJGAXZLBLMRWGGHFVEOADNNNYDZHEXOAWHTKNDAZTUFEBNRWMTMFLXXNAPAUNGUICGNDZGURUZJZPINABPIDJEHL"},
            {"JBKJJXZOVCQZBKKKWFGWLNCZBPJTFCTMZABACKCJTRNQVODXWLXIUQWCIPVRFEvNCYvSDVVWOVEODZThXRKwwagprhtkenhahhzwctsndzkbnhnagmdlvkhfctrawwjvinqukorochovrilrlczpghcqbynyhdjwgbfgpgphbcxpogfjtevavydrgclvdjiflwrqhengdujnvkskkzvyoirkseejespiptovwoprypavmcpsyorjwejdneolfkvigaogrbsxmlapvlvmkhlmvlkpujnwhiwzacvbiqogwpbqtdxmddxndafainuwwgp",
                    "JBKJJXZOVCQZBKKKWFGWLNCZBPJTFCTMZABACKCJTRNQVODXWLXIUQWCIPVRFENCYSDVVWOVEODZTXRK"},
            {"SFIATFRjQKPFKAYUvNsCOLKJYIIiFJRUCPSPQXWKCHWkGkKDWIJKDENNUbAtBIHKPLXgZIFZFFBZTTaUKxNyTXDQHLEQQPPWKADrOABSXACAHEBsVQXPKOIFLGHFUADTDRHPOWOtTMQJWGKIKnCNAsDJUDFBGrWSJMYOYKCEOMGRFFFQTHOSjNTUEZQTZFJKGLPUYCThYEPUZJAKZZIYPMjNWTFAPWRXIQUVWBCEOBGVWZUMXRUHWQxaqctggnauhhwkmccqlvcgxpcvavjesbll",
                    "SFIATFRQKPFKAYUNCOLKJYIIFJRUCPSPQXWKCHWGKDWIJKDENNUABIHKPLXZIFZFFBZTTUKNTXDQHLEQQPPWKADOABSXACAHEBVQXPKOIFLGHFUADTDRHPOWOTMQJWGKIKCNADJUDFBGWSJMYOYKCEOMGRFFFQTHOSNTUEZQTZFJKGLPUYCTYEPUZJAKZZIYPMNWTFAPWRXIQUVWBCEOBGVWZUMXRUHWQ"},
            {"SKPKWSWVQMUOOOALHWTyelykxzhijylhgnfkamnyrfiianieezrqyailzcnaitdrqrmyvknwfyclgbzfhbggqzwpvaeqtootinpsojvjtycjidbjqyxnxctmahaxurjtvicvvjopavvctqrzrmtvxyvvqitehiieejarwuxxzszqgktdpekvavxogwopdjksxrejruvgububjczhUpcelvomflafimcizhnbmrxicjdjerHfqgynrdspjugpdcoeocouqsqpbrmkyamzfufhjxdxgfsvqetbbiozcfkcdcmjjzvdknmrbbeqokpmccjswhsmaqjywlebgrgpaeehnhxogpszqjvvajlpvcrzdyexppcmuygyxlcnybqwkijhhxzjbezktzszjiiqmpvbqzzozjaronkoizxkoolpmuyftjighbineldtmmffoizyasoiiajhlNpbsqqkmkhfvommjvphetohdnwvebjbbfkurslickonsqoilvnjvzybxgjvmcgpxkzrantmeeyyheuczjkcoogheakljrrjipsmhfnraazuainbuJblnfbziuzivusmflzbmfjpfkywnvudjdkgptiqunujacqlykokpzwlqcrxfhvgrclnhibntxgthkrmqhhsmkdesakc",
                    "SKPKWSWVQMUOOOALHWT"},
            {"LZSIERCvcdjprqqqfelwwxcbmwmikpfvhspvewwdufeaggiklsleaopnhlvwdryzegouexrbxxcmiapvxsdercuauypdzlmjzuqvawakcywjduehaegxzdaeiqlufqwu",
                    "LZSIERC"}
    };

    public static void main(String[] args) {
        /*//System.out.println(abbreviation("daBcd","ABC"));
        System.out.println(abbreviation("AbcDE","ABDE"));
        System.out.println(abbreviation("beFgH","EFG"));
        *//*System.out.println(abbreviation("cDE","DE"));
        System.out.println(abbreviation("DE","DE"));*//*
        //System.out.println(abbreviation("AbcDE","AFDE"));*/

        for (String[] testCase : testCases) {
            System.out.println(abbreviation(testCase[0], testCase[1]));
        }
    }

    static String abbreviation(String a, String b) {
        //return abbrRecur(a, b, 0, 0) ? "YES" : "NO";
        return addreviationNoRecur(a, b) ? "YES" : "NO";
    }

    static boolean addreviationNoRecur(String a, String b) {
        boolean[][] cache = new boolean[a.length() + 1][b.length() + 1];
        cache[0][0] = true;
        for (int c = 1; c <= b.length(); c++) {
            cache[0][c] = false;
        }

        for (int r = 1; r <= a.length(); r++) {
            cache[r][0] = cache[r - 1][0] && Character.isLowerCase(a.charAt(r - 1));
        }

        for (int r = 1; r <= a.length(); r++) {
            for (int c = 1; c <= b.length(); c++) {
                if(Character.isLowerCase(a.charAt(r-1))) {
                    cache[r][c] = cache[r-1][c] || (Character.toUpperCase(a.charAt(r-1)) == b.charAt(c-1)) && cache[r-1][c-1];
                }else {
                    cache[r][c] = a.charAt(r-1) == b.charAt(c-1) && cache[r-1][c-1];
                }
            }

            //Util.printMatrix(cache);
        }
        //Util.printMatrix(cache);
        return cache[a.length()][b.length()];
    }

    static boolean abbrRecur(String a, String b, int aIndex, int bIndex) {
        if (aIndex >= a.length()) {
            return bIndex == b.length();
        }

        if (bIndex >= b.length()) {
            boolean result = true;
            for (int i = aIndex; i < a.length(); i++) {
                if (Character.isUpperCase(a.charAt(i))) {
                    result = false;
                    break;
                }
            }
            return result;
        }

        if (Character.isLowerCase(a.charAt(aIndex))) {
            if (Character.toUpperCase(a.charAt(aIndex)) == b.charAt(bIndex)) {
                return abbrRecur(a, b, aIndex + 1, bIndex) || abbrRecur(a, b, aIndex + 1, bIndex + 1);
            } else {
                return abbrRecur(a, b, aIndex + 1, bIndex);
            }
        } else if (a.charAt(aIndex) == b.charAt(bIndex)) {
            return abbrRecur(a, b, aIndex + 1, bIndex + 1);
        } else {
            return false;
        }

    }

}
