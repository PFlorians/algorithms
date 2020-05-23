package kmp;

public class Kmp {//string comparisson algorithm
	private int shift[];
	private void shiftCorrection(int []tmp_shift)
	{
		int i,j;
		shift = new int[tmp_shift.length-1];
		for(i=1,j=0;i<tmp_shift.length;i++,j++)
		{
			shift[j]=tmp_shift[i];
		}
		shift[0]=-1;
	}
	private void initShift(char[] pattern)
	{
		int current_index, shift_index;
		int m = pattern.length;
		int tmp_shift[];
		tmp_shift = new int[pattern.length+1];//compensation,0 index is -1
		tmp_shift[0] = -1;
		for(current_index=0,shift_index=-1;current_index<m;)
		{
			while((shift_index>=0) && (pattern[current_index]!=pattern[shift_index]))
			{
				shift_index=tmp_shift[shift_index];
			}
			current_index++;
			shift_index++;
			tmp_shift[current_index] = shift_index;
		}
		shiftCorrection(tmp_shift);
	}
	public int subString(String txt, String pattern)
	{
		char t[] = txt.toCharArray();
		char p[] = pattern.toCharArray();
		int i, j;
		this.initShift(p);//initialize shift here
		for(i=0,j=-1;i<t.length;)
		{
			if(t[i]!=p[j+1] && j>=0)
			{
				j=(shift[j]>0)?shift[j]-1:-1;
				continue;
			}
			else if(t[i]!=p[j+1] && j<0)
			{
				i++;
				continue;
			}
			i++;
			j++;
		}
		if(j == p.length-1)
		{
			return i-p.length;
		}
		else
		{
			return -1;
		}
	}
}
