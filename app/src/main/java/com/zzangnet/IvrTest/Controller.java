package com.zzangnet.IvrTest;

import java.util.concurrent.BlockingDeque;

public class Controller
{
    private boolean started;

    private RecordTask recordTask;
    private RecognizerTask recognizerTask;
    private MainActivity mainActivity;
    BlockingDeque<DataBlock> blockingQueue;

}
