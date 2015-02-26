package org.thinkadv.dp.structural.adapter;

public class FLVPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVlc(String fileName) {
		// do nothing
	}

	@Override
	public void playMp4(String fileName) {
		// do nothing
	}

	@Override
	public void playFlv(String fileName) {
		System.out.println("Playing flv file. Name: " + fileName);

	}

}
