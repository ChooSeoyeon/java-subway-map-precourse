package subway.controller;

import java.util.function.Supplier;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayMapController {
    private final InputView inputView;
    private final OutputView outputView;

    public SubwayMapController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            String function = repeatUntilSuccessWithReturn(inputView::readFunction);
            if (function.equals("Q")) {
                return;
            }
            if (function.equals("1")) {
                return;
            }
            if (function.equals("2")) {
                return;
            }
            if (function.equals("3")) {
                return;
            }
            if (function.equals("4")) {
                return;
            }
        }
    }

    private <T> T repeatUntilSuccessWithReturn(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void repeatUntilSuccess(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
