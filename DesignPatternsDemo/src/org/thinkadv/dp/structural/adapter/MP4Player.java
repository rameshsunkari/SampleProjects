package org.thinkadv.dp.structural.adapter;

public class MP4Player implements AdvancedMediaPlayer {

	@Override
	   public void playVlc(String fileName) {
	      //do nothing
	   }

	   @Override
	   public void playMp4(String fileName) {
	      System.out.println("Playing mp4 file. Name: "+ fileName);		
	   }

	@Override
	public void playFlv(String fileName) {
		// TODO Auto-generated method stub
		
	}

}
