package net.simplyrin.processorinfo.bungee.command;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.simplyrin.processorinfo.bungee.Main;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

/**
 * Created by SimplyRin on 2019/04/20.
 *
 * Copyright (c) 2019 SimplyRin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class CommandProcessorInfo extends Command {

	private Main instance;

	public CommandProcessorInfo(Main instance) {
		super("processorinfo");
		this.instance = instance;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (!sender.hasPermission("processorinfo.show")) {
			this.instance.sendMessage(sender, "&cYou don't have access to this command!");
			return;
		}

		SystemInfo systemInfo = this.instance.getSystemInfo();
		HardwareAbstractionLayer hardware = systemInfo.getHardware();

		this.instance.sendMessage(sender, "&aOS: " + systemInfo.getOperatingSystem());
		this.instance.sendMessage(sender, "&aCPU: " + hardware.getProcessor());
		this.instance.sendMessage(sender, "&aMemory: " + FormatUtil.formatBytes(hardware.getMemory().getTotal()));
		return;
	}

}
