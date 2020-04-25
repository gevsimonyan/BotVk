package am.gev.gamebot;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.appnews.GetNewsForApp;
import com.lukaspradel.steamapi.data.json.appnews.Newsitem;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetNewsForAppRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import com.petersamokhin.bots.sdk.clients.Group;
import com.petersamokhin.bots.sdk.objects.Message;

public class Main {
    private static final String VK_KEY = "VK KEY";
    private static final String STEAM_KEY = "STEAM KEY";
    private static final Integer STEAM_CSGO_KEY = 730;
    private static final Integer STEAM_GARRYSMOD_KEY = 4000;
    private static final Integer STEAM_DOTA2_KEY = 570;
    private static final Integer STEAM_PUBG_KEY = 578080;
    private static final Integer STEAM_RAINBOWSIXSIEDGE_KEY = 359550;


    public static void main(String[] args) throws SteamApiException {

        Group group = new Group(194107759, VK_KEY);

        //csgo news send to bot
        SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder(STEAM_KEY).build();
        GetNewsForAppRequest request = SteamWebApiRequestFactory.createGetNewsForAppRequest(STEAM_CSGO_KEY);
        GetNewsForApp getNewsForApp = client.processRequest(request);

        //garrys mod news send to bot
        SteamWebApiClient client1 = new SteamWebApiClient.SteamWebApiClientBuilder(STEAM_KEY).build();
        GetNewsForAppRequest request1 = SteamWebApiRequestFactory.createGetNewsForAppRequest(STEAM_GARRYSMOD_KEY);
        GetNewsForApp getNewsForApp1 = client1.processRequest(request1);

        //dota 2 news send to bot
        SteamWebApiClient client2 = new SteamWebApiClient.SteamWebApiClientBuilder(STEAM_KEY).build();
        GetNewsForAppRequest request2 = SteamWebApiRequestFactory.createGetNewsForAppRequest(STEAM_DOTA2_KEY);
        GetNewsForApp getNewsForApp2 = client2.processRequest(request2);

        //pubg news send to bot
        SteamWebApiClient client3 = new SteamWebApiClient.SteamWebApiClientBuilder(STEAM_KEY).build();
        GetNewsForAppRequest request3 = SteamWebApiRequestFactory.createGetNewsForAppRequest(STEAM_RAINBOWSIXSIEDGE_KEY);
        GetNewsForApp getNewsForApp3 = client3.processRequest(request3);

        //rainbow six edge news send to bot
        SteamWebApiClient client4 = new SteamWebApiClient.SteamWebApiClientBuilder(STEAM_KEY).build();
        GetNewsForAppRequest request4 = SteamWebApiRequestFactory.createGetNewsForAppRequest(STEAM_PUBG_KEY);
        GetNewsForApp getNewsForApp4 = client4.processRequest(request4);


        group.onSimpleTextMessage(message -> {
            //cs:go news send
            if (message.getText().equals("cs:go")) {
                Message toSend = new Message()
                        .from(group)
                        .to(message.authorId());
                getNewsForApp.getAppnews().getNewsitems().stream()
                        .map(Newsitem::getContents)
                        .forEach(toSend::text);
                toSend.send();
            }
            //garrys mod news send
            else if (message.getText().equals("garrys mod")) {
                Message toSend1 = new Message()
                        .from(group)
                        .to(message.authorId());
                getNewsForApp1.getAppnews().getNewsitems().stream()
                        .map(Newsitem::getContents)
                        .forEach(toSend1::text);
                toSend1.send();
            }
            //dota 2 news send
            else if (message.getText().equals("dota 2")) {
                Message toSend2 = new Message()
                        .from(group)
                        .to(message.authorId());
                getNewsForApp2.getAppnews().getNewsitems().stream()
                        .map(Newsitem::getContents)
                        .forEach(toSend2::text);
                toSend2.send();
            }
            //pubg news send
            else if (message.getText().equals("pubg")) {
                Message toSend3 = new Message()
                        .from(group)
                        .to(message.authorId());
                getNewsForApp3.getAppnews().getNewsitems().stream()
                        .map(Newsitem::getContents)
                        .forEach(toSend3::text);
                toSend3.send();
            }
            //rainbow six edge news send
            else if (message.getText().equals("rainbow six edge")) {
                Message toSend4 = new Message()
                        .from(group)
                        .to(message.authorId());
                getNewsForApp4.getAppnews().getNewsitems().stream()
                        .map(Newsitem::getContents)
                        .forEach(toSend4::text);
                toSend4.send();
            }
            else{
                Message toSend5 = new Message();
                toSend5.text("Не знаю такой игры :D");
                toSend5.send();
            }
        });
    }
}
