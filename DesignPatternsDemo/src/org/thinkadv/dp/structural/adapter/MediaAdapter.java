package org.thinkadv.dp.structural.adapter;

public class MediaAdapter implements MediaPlayer {

	private AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer = new VlcPlayer();

		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer = new MP4Player();
		} else if (audioType.equalsIgnoreCase("flv")) {
			advancedMusicPlayer = new FLVPlayer();
		}
	}

	@Override
	public void play(String audioType, String fileName) {

		if (audioType.equalsIgnoreCase("vlc")) {
			advancedMusicPlayer.playVlc(fileName);
		} else if (audioType.equalsIgnoreCase("mp4")) {
			advancedMusicPlayer.playMp4(fileName);
		} else if (audioType.equalsIgnoreCase("flv")) {
			advancedMusicPlayer.playFlv(fileName);
		}
	}

}
