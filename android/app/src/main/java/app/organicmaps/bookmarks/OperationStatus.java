package app.organicmaps.bookmarks;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

import app.organicmaps.bookmarks.data.Error;
import app.organicmaps.bookmarks.data.Result;

public class OperationStatus implements Parcelable
{
  @Nullable
  private final Result mResult;
  @Nullable
  private final Error mError;

  OperationStatus(@Nullable Result result, @Nullable Error error)
  {
    mResult = result;
    mError = error;
  }

  private OperationStatus(Parcel in)
  {
    mResult = in.readParcelable(Result.class.getClassLoader());
    mError = in.readParcelable(Error.class.getClassLoader());
  }

  public static final Creator<OperationStatus> CREATOR = new Creator<OperationStatus>()
  {
    @Override
    public OperationStatus createFromParcel(Parcel in)
    {
      return new OperationStatus(in);
    }

    @Override
    public OperationStatus[] newArray(int size)
    {
      return new OperationStatus[size];
    }
  };

  @Override
  public int describeContents()
  {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags)
  {
    dest.writeParcelable(mResult, flags);
    dest.writeParcelable(mError, flags);
  }

  @Override
  public String toString()
  {
    return "OperationStatus{" +
           "mResult=" + mResult +
           ", mError=" + mError +
           '}';
  }
}
