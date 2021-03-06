/*
 * This file is part of gplugins, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2017, Jamie Mansfield <https://www.jamierocks.uk/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package uk.jamierocks.canary.gplugins.plugin.lifecycle;

import net.canarymod.exceptions.PluginLoadFailedException;
import net.canarymod.plugin.PluginDescriptor;
import net.minecraft.launchwrapper.Launch;

import java.io.File;
import java.net.MalformedURLException;

/**
 * The plugin lifecycle for gplugins, running on the NeptuneMod
 * server software.
 */
public class NeptuneGPluginLifecycle extends AbstractGPluginLifecycle {

    public NeptuneGPluginLifecycle(final PluginDescriptor desc) {
        super(desc);
    }

    @Override
    protected ClassLoader getClassLoader() throws PluginLoadFailedException {
        try {
            Launch.classLoader.addURL(new File(this.desc.getPath()).toURI().toURL());
            return Launch.classLoader;
        }
        catch (final MalformedURLException ex) {
            throw new PluginLoadFailedException("Failed to create plugin class loader!", ex);
        }
    }

}
