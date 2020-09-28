/*
 * This file is part of adventure, licensed under the MIT License.
 *
 * Copyright (c) 2017-2020 KyoriPowered
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
package net.kyori.adventure.text.serializer.gson;

import com.google.gson.JsonElement;
import java.util.Map;
import java.util.stream.Stream;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.EntityNBTComponent;

class EntityNBTComponentTest extends AbstractComponentTest<EntityNBTComponent> {
  @Override
  Stream<Map.Entry<EntityNBTComponent, JsonElement>> tests() {
    return Stream.of(
      entry(
        Component.entityNBT().nbtPath("abc").selector("test").build(),
        json -> {
          json.addProperty(ComponentSerializerImpl.NBT, "abc");
          json.addProperty(ComponentSerializerImpl.NBT_INTERPRET, false);
          json.addProperty(ComponentSerializerImpl.NBT_ENTITY, "test");
        }
      ),
      entry(
        Component.entityNBT().nbtPath("abc").selector("test").interpret(true).build(),
        json -> {
          json.addProperty(ComponentSerializerImpl.NBT, "abc");
          json.addProperty(ComponentSerializerImpl.NBT_INTERPRET, true);
          json.addProperty(ComponentSerializerImpl.NBT_ENTITY, "test");
        }
      )
    );
  }
}
