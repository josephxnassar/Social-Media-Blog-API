package Controller;

import Model.Account;
import Model.Message;

import Service.AccountService;
import Service.MessageService;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.javalin.Javalin;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    AccountService accountService;
    MessageService messageService;

    public SocialMediaController () {
        this.accountService = new AccountService();
        this.messageService = new MessageService();
    }

    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */
    public Javalin startAPI() {
        Javalin app = Javalin.create();

        // register user
        app.post("/register", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Account account = mapper.readValue(ctx.body(), Account.class);
            Account addedAccount = accountService.addAccount(account);

            if (addedAccount != null) {
                ctx.json(addedAccount).status(200);
            }
            else {
                ctx.status(400);
            }
        });

        // login user
        app.post("/login", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Account account = mapper.readValue(ctx.body(), Account.class);
            Account addedAccount = accountService.loginAccount(account);

            if (addedAccount != null) {
                ctx.json(addedAccount).status(200);
            }
            else {
                ctx.status(401);
            }
        });

        // create message
        app.post("/messages", ctx -> {
            ObjectMapper mapper = new ObjectMapper();
            Message message = mapper.readValue(ctx.body(), Message.class);
            Message addedMessage = messageService.addMessage(message);

            if (addedMessage != null) {
                ctx.json(addedMessage).status(200);
            }
            else {
                ctx.status(400);
            }
        });

        // get messages
        app.get("/messages", ctx -> {
            List<Message> messages = messageService.getAllMessages();
            ctx.json(messages);
        });

        // get message
        app.get("/messages/{message_id}", ctx -> {
            int message_id = Integer.parseInt(ctx.pathParam("message_id"));
            Message message = messageService.getMessage(message_id);
            
            if (message != null) {
                ctx.json(message);
            }
            else {
                ctx.result("");
            }
        });

        // delete message
        app.delete("/messages/{message_id}", ctx -> {
            int message_id = Integer.parseInt(ctx.pathParam("message_id"));
            Message message = messageService.deleteMessage(message_id);

            if (message != null) {
                ctx.json(message);
            }
            else {
                ctx.result("");
            }
        });

        // update message
        app.patch("/messages/{message_id}", ctx -> {
            int message_id = Integer.parseInt(ctx.pathParam("message_id"));
            ObjectMapper mapper = new ObjectMapper();
            Message message = mapper.readValue(ctx.body(), Message.class);
            Message updatedMessage = messageService.modifyMessage(message.getMessage_text(), message_id);

            if (updatedMessage != null) {
                ctx.json(mapper.writeValueAsString(updatedMessage)).status(200);
            }
            else {
                ctx.status(400);
            }
        });

        // get message by user
        app.get("/accounts/{account_id}/messages", ctx -> {
            int account_id = Integer.parseInt(ctx.pathParam("account_id"));
            List<Message> messages = messageService.getMessages(account_id);
            ctx.json(messages).status(200);
        });

        return app;
    }
}