package pl.korniak.jacek.patronage.service;


import org.springframework.stereotype.Component;
import pl.korniak.jacek.patronage.model.Message;
import pl.korniak.jacek.patronage.model.Player;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerService {

    private static List<Player> players = new ArrayList<Player>();

    public Message create(Player player) {
        Message message = new Message();
        Long nextPlayerId = this.getNextPlayerId();
        player.setId(nextPlayerId);
        players.add(player);

        message.setMessage("New player with id: " + nextPlayerId + " was created successfully!");
        return message;
    }

    public Message update(Long playerId, Player player) {
        int playerUpdate = getPlayer(playerId);
        Message message = new Message();
        if (playerUpdate >= 0) {
            Player playerToUpdate = players.get(playerUpdate);
            playerToUpdate.setUsername(player.getUsername());
            playerToUpdate.setEmail(player.getEmail());
            message.setMessage("Player with id: " + playerId + " was updated successfully!");
            return message;
        } else {
            message.setMessage("Player with id: " + playerId + " was not found!");
            return message;
        }

    }

    public Player get(Long playerId) {
        int index = getPlayer(playerId);
        if (index >= 0) {
            return players.get(index);
        } else {
            return null;
        }
    }

    public List<Player>  getAll() {

      return players;
    }

    public Message delete(Long playerId) {
        Message message = new Message();
        int index = getPlayer(playerId);
        if (index >= 0) {
            players.remove(index);
            message.setMessage("Player with id: " + playerId + " was removed successfully!");
        } else {
            return null;
        }

        return message;
    }

    public Long getNextPlayerId() {

        Long nextPlayerId = 0L;

        for (int i = 0; i < players.size(); i++) {

            Player player = players.get(i);

            if (nextPlayerId < player.getId()) {
                nextPlayerId = player.getId();
            }
        }

        return nextPlayerId + 1;
    }

    public int getPlayer(Long playerId) {

        for (int i = 0; i < players.size(); i++) {

            Player player = players.get(i);

            if (playerId.equals(player.getId())) {
                return i;
            }

        }

        return -1;
    }

}
